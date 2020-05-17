/*
 * module: fundermental
 * file: CountryMapper.java
 * date: 5/17/20 11:28 AM
 * author: VectorJu
 */

/*
 * module: fundermental
 * file: ClusterCountryMapper.java
 * date: 5/12/20 12:32 AM
 * author: VectorJu
 */

/**
 * @create 2020-05-12 00:32
 * @desc
 **/
package com.sdlx.sh.vector.multidb.xdb.mapper.cluster;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClusterCountryMapper {
    int insert(com.sdlx.sh.vector.multidb.xdb.entity.Country country);

    int insertSelective(com.sdlx.sh.vector.multidb.xdb.entity.Country Country);
}

