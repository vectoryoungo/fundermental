/*
 * module: fundermental
 * file: Country.java
 * date: 5/12/20 12:29 AM
 * author: VectorJu
 */

/**
 * @create 2020-05-12 00:29
 * @desc mapper
 **/
package com.sdlx.sh.vector.multidb.xdb;

public interface Country {

    int insert(com.sdlx.sh.vector.multidb.xdb.entity.Country country);

    int insertSelective(com.sdlx.sh.vector.multidb.xdb.entity.Country Country);
}

