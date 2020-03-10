/*
 * module: fundermental
 * file: SpringFeatureSimulator.java
 * date: 9/12/19 1:55 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-12 13:54
 * @desc learn spring feature
 **/
package com.xlab.service_java_infrastructure.spring;

import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.BeanMetadataAttribute;
import org.springframework.beans.BeanMetadataAttributeAccessor;
import org.springframework.beans.BeanMetadataElement;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.PlatformTransactionManagerCustomizer;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.*;
import org.springframework.core.AttributeAccessor;
import org.springframework.core.AttributeAccessorSupport;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AbstractRefreshableWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.lang.reflect.Proxy;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

@Configuration
public class SpringFeatureSimulator {

    public static void main(String[] args) {
        //Proxy proxy;
        //AopAutoConfiguration.CglibAutoProxyConfiguration cglibAutoProxyConfiguration;
        //AopAutoConfiguration.JdkDynamicAutoProxyConfiguration jdkDynamicAutoProxyConfiguration;
        //AnnotationConfigServletWebServerApplicationContext annotationConfigServletWebServerApplicationContext;
        //AnnotationConfigReactiveWebServerApplicationContext annotationConfigReactiveWebServerApplicationContext;
        AttributeAccessor attributeAccessor;
        AttributeAccessorSupport attributeAccessorSupport;
        BeanDefinition beanDefinition;
        BeanMetadataAttributeAccessor beanMetadataAttributeAccessor;
        BeanMetadataElement beanMetadataElement;
        AbstractBeanDefinition abstractBeanDefinition;
        RootBeanDefinition rootBeanDefinition;
        BeanDefinitionReader beanDefinitionReader;
        XmlBeanDefinitionReader xmlBeanDefinitionReader;

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(256);
        DefaultListableBeanFactory defaultListableBeanFactory;
        RejectedExecutionHandler rejectedExecutionHandler;
        PlatformTransactionManagerCustomizer platformTransactionManagerCustomizer;
        ContextLoaderListener contextLoaderListener;
        ClassPathScanningCandidateComponentProvider classPathScanningCandidateComponentProvider;
        InstantiationAwareBeanPostProcessorAdapter instantiationAwareBeanPostProcessorAdapter;
        PoolProperties poolProperties = new PoolProperties();
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(SpringFeatureSimulator.class);
        annotationConfigApplicationContext.refresh();
        InjectionInnerClass injectionInnerClass = annotationConfigApplicationContext.getBean(InjectionInnerClass.class);
        injectionInnerClass.msgNotification();
        PropertySource propertySource;
        Environment environment;
    }

    @VectorComponent
    public static class InjectionInnerClass {
        public void msgNotification() {
            System.out.println(" InjectionInnerClass msgNotification ");
        }
    }

    /**
     * ApplicationContext允许上下文嵌套，通过保持父上下文可以维持一个上下文体系。
     * 对于bean的查找可以在这个上下文体系中发生，首先检查当前上下文，其次是父上下文，逐级向上，
     * 这样为不同的Spring应用提供了一个共享的bean定义环境。　
     * ApplicationContext 容器的初始化流程主要由 AbstractApplicationContext 类中的 refresh 方法实现。
     * 大致过程为:
     * 为 BeanFactory 对象执行后续处理(如:context:propertyPlaceholder等)->
     * 在上下文(Context)中注册 bean->
     * 为 bean 注册拦截处理器(AOP 相关)->
     * 初始化上 下文消息(初始化 id 为 messgeSource 的国际化 bean 对象)->
     * 初始化事件多播(处理事件监 听，如ApplicationEvent等)->
     * 初始化主题资源(SpringUI 主题 ThemeSource)->
     * 注册自定义 监听器->
     * 实例化所有非 lazy-init 的 singleton 实例->
     * 发布相应事件(Lifecycle 接口相关实现类的生命周期事件发布)。
     * 在 spring 中，构建容器的过程都是同步的。
     * 同步操作是为了保证容器构建的过程中，不出现多线程资源冲突问题（因为对象的构建、资源的扫描、文件的扫描如果存在多线程对文件的扫描问题，会出现锁的问题）。
     */
    public void springClassStructureExplorer() {
        BeanFactory beanFactory;//the basic interface of spring
        ListableBeanFactory listableBeanFactory;//the child of BeanFactory
        HierarchicalBeanFactory hierarchicalBeanFactory;//the child of BeanFactory
        AutowireCapableBeanFactory autowireCapableBeanFactory;//the child of BeanFactory
        DefaultSingletonBeanRegistry defaultSingletonBeanRegistry;

        // this interface is the top of Spring and provide many other features like:MessageSource ResourcePatternResolver ApplicationEventPublisher
        ApplicationContext applicationContext;

        //directly extends from ApplicationContext
        // SPI interface to be implemented by most if not all application contexts.
        // Provides facilities to configure an application context in addition
        // to the application context client methods in the
        ConfigurableApplicationContext configurableApplicationContext;

        //directly extends from ApplicationContext
        // Interface to provide configuration for a web application. This is read-only while
        // he application is running, but may be reloaded if the implementation supports this.
        // This interface adds a {@code getServletContext()} method to the generic
        // ApplicationContext interface, and defines a well-known application attribute name
        // that the root context must be bound to in the bootstrap process.
        // Like generic application contexts, web application contexts are hierarchical.
        // There is a single root context per application, while each servlet in the application
        // (including a dispatcher servlet in the MVC framework) has its own child context.
        // In addition to standard application context lifecycle capabilities,
        // WebApplicationContext implementations need to detect {@link ServletContextAware}
        // beans and invoke the {@code setServletContext} method accordingly.
        WebApplicationContext webApplicationContext;

        //directly extends from WebApplicationContext and ConfigurableApplicationContext
        //Note: The setters of this interface need to be called before an
        //invocation of the {@link #refresh} method inherited from
        //org.springframework.context.ConfigurableApplicationContext
        //They do not cause an initialization of the context on their own.
        ConfigurableWebApplicationContext configurableWebApplicationContext;

        // directly implementation of ConfigurableApplicationContext
        // also implementation of org.springframework.context.ApplicationContext interface.
        // Doesn't mandate the type of storage used for configuration; simply
        // * implements common context functionality. Uses the Template Method design pattern,
        // * requiring concrete subclasses to implement abstract methods.
        // * In contrast to a plain BeanFactory, an ApplicationContext is supposed
        // * to detect special beans defined in its internal bean factory:
        // * Therefore, this class automatically registers
        // * {@link org.springframework.beans.factory.config.BeanFactoryPostProcessor BeanFactoryPostProcessors},
        // * {@link org.springframework.beans.factory.config.BeanPostProcessor BeanPostProcessors}
        // * and {@link org.springframework.context.ApplicationListener ApplicationListeners}
        // * which are defined as beans in the context.
        // *
        // * <p>A {@link org.springframework.context.MessageSource} may also be supplied
        // * as a bean in the context, with the name "messageSource"; otherwise, message
        // * resolution is delegated to the parent context. Furthermore, a multicaster
        // * for application events can be supplied as "applicationEventMulticaster" bean
        // * of type {@link org.springframework.context.event.ApplicationEventMulticaster}
        // * in the context; otherwise, a default multicaster of type
        // * {@link org.springframework.context.event.SimpleApplicationEventMulticaster} will be used.
        // *
        // * <p>Implements resource loading through extending
        // * {@link org.springframework.core.io.DefaultResourceLoader}.
        // * Consequently treats non-URL resource paths as class path resources
        // * (supporting full class path resource names that include the package path,
        // * e.g. "mypackage/myresource.dat"), unless the {@link #getResourceByPath}
        // * method is overwritten in a subclass.
        // *
        AbstractApplicationContext abstractApplicationContext;

        //directly extends from AbstractApplicationContext
        //Base class for {@link org.springframework.context.ApplicationContext}
        //implementations which are supposed to support multiple calls to {@link #refresh()},
        //creating a new internal bean factory instance every time.
        //Typically (but not necessarily), such a context will be driven by
        //a set of config locations to load bean definitions from.
        //
        //The only method to be implemented by subclasses is {@link #loadBeanDefinitions},
        //which gets invoked on each refresh. A concrete implementation is supposed to load
        //bean definitions into the given
        //{@link org.springframework.beans.factory.support.DefaultListableBeanFactory},
        //typically delegating to one or more specific bean definition readers.
        //
        //Note that there is a similar base class for WebApplicationContexts.
        //org.springframework.web.context.support.AbstractRefreshableWebApplicationContext
        //provides the same subclassing strategy, but additionally pre-implements
        //all context functionality for web environments. There is also a
        //pre-defined way to receive config locations for a web context.
        //
        //Concrete standalone subclasses of this base class, reading in a
        //specific bean definition format, are {@link ClassPathXmlApplicationContext}
        //and {@link FileSystemXmlApplicationContext}, which both derive from the
        //common {@link AbstractXmlApplicationContext} base class;
        //{@link org.springframework.context.annotation.AnnotationConfigApplicationContext}
        //supports {@code @Configuration}-annotated classes as a source of bean definitions.
        AbstractRefreshableApplicationContext abstractRefreshableApplicationContext;


        //directly extends from AbstractRefreshableApplicationContext
        //AbstractRefreshableApplicationContext subclass that adds common handling
        //of specified config locations. Serves as base class for XML-based application
        //context implementations such as ClassPathXmlApplicationContext and
        //FileSystemXmlApplicationContext, as well as
        //org.springframework.web.context.support.XmlWebApplicationContext.
        AbstractRefreshableConfigApplicationContext abstractRefreshableConfigApplicationContext;

        //directly extends from AbstractRefreshableConfigApplicationContext
        // Convenient base class for {@link org.springframework.context.ApplicationContext}
        // implementations, drawing configuration from XML documents containing bean definitions
        // understood by an {@link org.springframework.beans.factory.xml.XmlBeanDefinitionReader}.
        //
        // Subclasses just have to implement the {@link #getConfigResources} and/or
        // the {@link #getConfigLocations} method. Furthermore, they might override
        // the {@link #getResourceByPath} hook to interpret relative paths in an
        // environment-specific fashion, and/or {@link #getResourcePatternResolver}
        // for extended pattern resolution.
        AbstractXmlApplicationContext abstractXmlApplicationContext;

        //directly extends from AbstractRefreshableConfigApplicationContext and implementation of ConfigurableWebApplicationContext
        // org.springframework.context.support.AbstractRefreshableApplicationContext subclass which implements the org.springframework.web.context.ConfigurableWebApplicationContext
        // interface for web environments. Provides a "configLocations" property,to be populated through the ConfigurableWebApplicationContext interface on web application startup.
        //
        // This class is as easy to subclass as AbstractRefreshableApplicationContext:
        // All you need to implements is the {@link #loadBeanDefinitions} method;
        // see the superclass javadoc for details. Note that implementations are supposed
        // to load bean definitions from the files specified by the locations returned
        // by the {@link #getConfigLocations} method.
        //
        // Interprets resource paths as servlet context resources, i.e. as paths beneath
        // the web application root. Absolute paths, e.g. for files outside the web app root,
        // can be accessed via "file:" URLs, as implemented by org.springframework.core.io.DefaultResourceLoader
        //
        // In addition to the special beans detected by org.springframework.context.support.AbstractApplicationContext,
        // this class detects a bean of type org.springframework.ui.context.ThemeSource
        // in the context, under the special bean name "themeSource".
        //
        // This is the web context to be subclassed for a different bean definition format.
        // Such a context implementation can be specified as "contextClass" context-param
        // for org.springframework.web.context.ContextLoader or as "contextClass"
        // init-param for org.springframework.web.servlet.FrameworkServlet,replacing the default XmlWebApplicationContext. It will then automatically
        // receive the "contextConfigLocation" context-param or init-param, respectively.
        //
        // Note that WebApplicationContext implementations are generally supposed
        // to configure themselves based on the configuration received through the
        // ConfigurableWebApplicationContext interface. In contrast, a standalone
        // application context might allow for configuration in custom startup code
        // (for example, org.springframework.context.support.GenericApplicationContext).
        AbstractRefreshableWebApplicationContext abstractRefreshableWebApplicationContext;


        //directly extends from AbstractXmlApplicationContext and implementation of ApplicationContext
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        classPathXmlApplicationContext.refresh();


        //directly extends from AbstractXmlApplicationContext and implementation of ApplicationContext
        FileSystemXmlApplicationContext fileSystemXmlApplicationContext;


        //directly extends from AbstractRefreshableWebApplicationContext and implementation of ApplicationContext especially for web project org.springframework.web.context.WebApplicationContext} implementation
        // which takes its configuration from XML documents, understood by an org.springframework.beans.factory.xml.XmlBeanDefinitionReader.
        // This is essentially the equivalent of org.springframework.context.support.GenericXmlApplicationContext for a web environment.
        //
        // By default, the configuration will be taken from "/WEB-INF/applicationContext.xml" for the root context,
        // and "/WEB-INF/test-servlet.xml" for a context with the namespace "test-servlet" (like for a DispatcherServlet instance with the servlet-name "test").
        //
        // The config location defaults can be overridden via the "contextConfigLocation"
        // context-param of {@link org.springframework.web.context.ContextLoader} and servlet
        // init-param of {@link org.springframework.web.servlet.FrameworkServlet}. Config locations
        // can either denote concrete files like "/WEB-INF/context.xml" or Ant-style patterns
        // like "/WEB-INF/*-context.xml" (see {@link org.springframework.util.PathMatcher} javadoc for pattern details).
        // *
        // In case of multiple config locations, later bean definitions will override ones defined in earlier loaded files. This can be leveraged to
        // deliberately override certain bean definitions via an extra XML file.
        // *
        // For a WebApplicationContext that reads in a different bean definition format,create an analogous subclass of AbstractRefreshableWebApplicationContext.
        // Such a context implementation can be specified as "contextClass" context-param for ContextLoader or "contextClass" init-param for FrameworkServlet.
        // XMLWebApplicationContext是专门为web应用准备的，他允许从相对于web根目录的路劲中装载配置文件完成初始化工作，从XMLWebApplicationContext中可以获得ServletContext的引用，
        // 整个Web应用上下文对象将作为属性放置在ServletContext中，以便web应用可以访问spring上下文，
        // spring中提供WebApplicationContextUtils的getWebApplicationContext(ServletContext serviceContext)方法来获得XMLWebApplicationContext对象。
        // ContextLoaderListener和DispatcherServlet 会创建XMLWebApplicationContext容器，但是ContextLoaderListener监听器初始化完毕后，才会初始化Servlet
        XmlWebApplicationContext xmlWebApplicationContext;

    }

    /**
     * 探索Java Concurrent包下并发的使用场景以及性能
     */
    public void lockClassExplorer() {
        AbstractOwnableSynchronizer abstractOwnableSynchronizer;
        AbstractQueuedLongSynchronizer abstractQueuedLongSynchronizer;
        AbstractQueuedSynchronizer abstractQueuedSynchronizer;
        ArrayBlockingQueue arrayBlockingQueue;
        BlockingQueue blockingQueue;
        BlockingDeque blockingDeque;
        Condition condition;
        CyclicBarrier cyclicBarrier;
        CountedCompleter completer;
        CountDownLatch countDownLatch;
        CopyOnWriteArraySet copyOnWriteArraySet;
        CopyOnWriteArrayList copyOnWriteArrayList;
        ConcurrentSkipListMap concurrentSkipListMap;
        ConcurrentSkipListSet concurrentSkipListSet;
        ConcurrentNavigableMap concurrentNavigableMap;
        ConcurrentMap concurrentMap;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        ConcurrentLinkedDeque concurrentLinkedDeque;
        ConcurrentHashMap concurrentHashMap;
        CompletionStage completionStage;
        CompletionService completionService;
        CompletableFuture completableFuture;
        Callable callable;
        DelayQueue delayQueue;
        Delayed delayed;
        Executors executors;
        ExecutorCompletionService executorCompletionService;
        Executor executor;
        Exchanger exchanger;
        Future future;
        FutureTask futureTask;
        ForkJoinWorkerThread forkJoinWorkerThread;
        ForkJoinTask forkJoinTask;
        ForkJoinPool forkJoinPool;
        LockSupport.getBlocker(new Thread());
        Lock lock;
        LinkedBlockingDeque linkedBlockingDeque;
        LinkedBlockingQueue linkedBlockingQueue;
        LinkedTransferQueue linkedTransferQueue;
        PriorityBlockingQueue priorityBlockingQueue;
        Phaser phaser;
        ReentrantLock reentrantLock;
        ReentrantReadWriteLock reentrantReadWriteLock;
        RunnableScheduledFuture runnableScheduledFuture;
        RunnableFuture runnableFuture;
        RejectedExecutionHandler rejectedExecutionHandler;
        RecursiveTask recursiveTask;
        RecursiveAction recursiveAction;
        SynchronousQueue synchronousQueue;
        Semaphore semaphore;
        ScheduledExecutorService scheduledExecutorService;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        ScheduledFuture scheduledFuture;
        StampedLock stampedLock = new StampedLock();
        ThreadPoolExecutor threadPoolExecutor;
        ThreadFactory threadFactory;
        ThreadLocalRandom threadLocalRandom;
        TransferQueue transferQueue;
    }
}

