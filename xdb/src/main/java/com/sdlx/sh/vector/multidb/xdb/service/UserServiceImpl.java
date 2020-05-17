/*
 * module: fundermental
 * file: UserServiceImpl.java
 * date: 5/12/20 12:24 AM
 * author: VectorJu
 */

/**
 * @create 2020-05-12 00:24
 * @desc impl user service
 **/
package com.sdlx.sh.vector.multidb.xdb.service;

import com.sdlx.sh.vector.multidb.xdb.entity.Country;
import com.sdlx.sh.vector.multidb.xdb.mapper.cluster.ClusterCountryMapper;
import com.sdlx.sh.vector.multidb.xdb.mapper.master.MasterCountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;


@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private MasterCountryMapper masterCountryMapperMaster;
    @Autowired
    private ClusterCountryMapper clusterCountryMapperCluster;
    @Autowired
    private DataSource dataSource;

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class,transactionManager = "clusterTransactionManager",
            isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
    public int insert(Country country){
        try {
            System.out.println("datasource cluster " + dataSource.getConnection().getCatalog());
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return clusterCountryMapperCluster.insert(country);
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class,transactionManager = "masterTransactionManager",
            isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
    public int insertMaster(Country country){
        try {
            System.out.println("datasource master " + dataSource.getConnection().getCatalog());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return masterCountryMapperMaster.insert(country);
    }


}

