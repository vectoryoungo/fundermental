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
