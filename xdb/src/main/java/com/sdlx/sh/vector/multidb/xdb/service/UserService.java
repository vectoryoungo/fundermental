/*
 * module: fundermental
 * file: UserService.java
 * date: 5/12/20 12:24 AM
 * author: VectorJu
 */

/**
 * @create 2020-05-12 00:24
 * @desc service interface
 **/
package com.sdlx.sh.vector.multidb.xdb.service;

public interface UserService {
    int insert(com.sdlx.sh.vector.multidb.xdb.entity.Country country);

    int insertMaster(com.sdlx.sh.vector.multidb.xdb.entity.Country country);
}

