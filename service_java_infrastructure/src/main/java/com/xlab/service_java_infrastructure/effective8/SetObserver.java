/*
 * module: fundermental
 * file: SetObserver.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

/*
 * module: fundermental
 * file: SetObserver.java
 * date: 18-8-26 下午4:33
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-08-26 16:33
 * @desc functional interface
 **/
package com.xlab.service_java_infrastructure.effective8;

@FunctionalInterface
public interface SetObserver<E> {
    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}

