/*
 * module: fundermental
 * file: DataProcessService.java
 * date: 6/14/20 3:12 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-14 15:12
 * @desc test async data process when error occured
 **/
package com.xlab.service_java_infrastructure.spring.service;

import com.xlab.service_java_infrastructure.vo.AcceptContentVO;

public interface DataProcessService {
    void process(AcceptContentVO acceptContentVO);
}

