####第三章 Lambda表达式

**可以把Lambda表达式理解为简洁地表示可传递的匿名函数的一种方式：它没有名称，但它
                                    有参数列表、函数主体、返回类型，可能还有一个可以抛出的异常列表。**

_那到底在哪里可以使用Lambda呢？你可以在函数式接口上使用Lambda表达式。_   

**函数式接口**                                 
   
   `    因为Predicate仅仅定义了一个抽象方法：这就是函数式接口
   
    public interface Predicate<T>{
    boolean test (T t);
    }
   `
**函数式接口就是定义且只定义了一个抽象方法的接口**

**请注意，任何函数式接口都不允许抛出受检异常（checked exception）。如果你需要Lambda
  表达式来抛出异常，有两种办法：定义一个自己的函数式接口，并声明受检异常，或者把Lambda
  包在一个try/catch块中。**
  
_Lambda的类型是从使用Lambda的上下文推断出来的。上下文（比如，接受它传递的方法的
                              参数，或接受它的值的局部变量）中Lambda表达式需要的类型称为目标类型_
                              
**Stream接口的collect
  和reduce方法有何不同**   
  
    你可以像下面这样使
    用reduce方法来实现toListCollector所做的工作：
    Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
    List<Integer> numbers = stream.reduce(
    new ArrayList<Integer>(),
    (List<Integer> l, Integer e) -> {
    l.add(e);
    return l; },
    118 第6 章 用流收集数据
    (List<Integer> l1, List<Integer> l2) -> {
    l1.addAll(l2);
    return l1; });
    这个解决方案有两个问题：一个语义问题和一个实际问题。语义问题在于，reduce方法
    旨在把两个值结合起来生成一个新值，它是一个不可变的归约。与此相反，collect方法的设
    计就是要改变容器，从而累积要输出的结果。这意味着，上面的代码片段是在滥用reduce方
    法，因为它在原地改变了作为累加器的List。你在下一章中会更详细地看到，以错误的语义
    使用reduce方法还会造成一个实际问题：这个归约过程不能并行工作，因为由多个线程并发
    修改同一个数据结构可能会破坏List本身。在这种情况下，如果你想要线程安全，就需要每
    次分配一个新的List，而对象分配又会影响性能。这就是collect方法特别适合表达可变容
    器上的归约的原因，更关键的是它适合并行操作，本章后面会谈到这一点。
  
**还要注意，普通的单参数groupingBy(f)（其中f是分类函数）实际上是groupingBy(f,
  toList())的简便写法。**                        

**第七章 并行流**


_配置并行流使用的线程池_

    看看流的parallel方法，你可能会想，并行流用的线程是从哪儿来的？有多少个？怎么
    自定义这个过程呢？
    并行流内部使用了默认的ForkJoinPool（7.2节会进一步讲到分支/合并框架），它默认的
    线程数量就是你的处理器数量， 这个值是由Runtime.getRuntime().available-
    Processors()得到的。
    但是你可以通过系统属性java.util.concurrent.ForkJoinPool.common.
    parallelism来改变线程池大小，如下所示：
    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","12");
    这是一个全局设置，因此它将影响代码中所有的并行流。反过来说，目前还无法专为某个
    并行流指定这个值。一般而言，让ForkJoinPool的大小等于处理器数量是个不错的默认值，
    除非你有很好的理由，否则我们强烈建议你不要修改它。
    
    尽管如此，请记住，并行化并不是没有代价的。并行化过程本身需要对流做递归划分，把每
    个子流的归纳操作分配到不同的线程，然后把这些操作的结果合并成一个值。但在多个内核之间
    移动数据的代价也可能比你想的要大，所以很重要的一点是要保证在内核中并行执行工作的时间 
    比在内核之间传输数据的时间长。总而言之，很多情况下不可能或不方便并行化。然而，在使用
    并行Stream加速代码之前，你必须确保用得对；如果结果错了，算得快就毫无意义了。让我们
    来看一个常见的陷阱
    
    错用并行流而产生错误的首要原因，就是使用的算法改变了某些共享状态。下面是另一种实
    现对前n个自然数求和的方法，但这会改变一个共享累加器：
    
    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }
    public class Accumulator {
        public long total = 0;
        public void add(long value) { total += value; }
    }