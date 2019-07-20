/*
 * module: fundermental
 * file: AbstractTemplate.java
 * date: 7/20/19 6:34 PM
 * author: VectorJu
 */

/**
 * @create 2019-07-20 18:34
 * @desc 一个较为完整的模板定义示例
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter15;

public abstract class AbstractTemplate {

    /**
     * 模板方法
     */
    public final void tempalteMethod() {

        //fist step 第一步
        //second step 第二步
        //third step 第三步
        //fourth step 第四步
        //fifth step 第五步

    }

    //第一步，算法中的步骤，固定实现，子类不需要访问
    private void operation1() {
        //specific logic code

    }

    //第二步，算法中的步骤，固定实现，子类可能需要访问
    protected final void operation2() {
        //specific logic code
    }

    //具体的AbstractClass操作，子类的公共功能，但通常不是具体的算法步骤
    protected void commonOperation(){
        //specific logic code
    }

    //原语操作1 算法中的必要步骤，父类无法确定如何真正实现，需要子类来实现
    protected abstract void doPrimitiveOperation1();
    //原语操作2 算法中的必要步骤，父类无法确定如何真正实现，需要子类来实现
    protected abstract void doPrimitiveOperation2();

    //钩子操作，算法中的步骤，不一定需要，提供默认实现 由子类选择并具体实现
    protected void hookOperation1() {

    }

    //工厂方法，创建某个对象，这里用Object代替了，在算法实现中可能需要
    protected abstract Object createOneObject();

}

