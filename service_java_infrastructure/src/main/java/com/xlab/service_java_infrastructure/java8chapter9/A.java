/*
 * module: fundermental
 * file: A.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

/*
 * module: fundermental
 * file: A.java
 * date: 18-6-29 上午9:24
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-29 09:24
 * @desc test A
 **/
package com.xlab.service_java_infrastructure.java8chapter9;

public interface A {
    default void hello(){
        System.out.println("Hello from A");
    }
}

