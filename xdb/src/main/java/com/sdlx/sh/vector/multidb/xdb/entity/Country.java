/*
 * module: fundermental
 * file: Country.java
 * date: 5/12/20 12:26 AM
 * author: VectorJu
 */

/**
 * @create 2020-05-12 00:26
 * @desc do
 **/
package com.sdlx.sh.vector.multidb.xdb.entity;

import java.io.Serializable;

public class Country implements Serializable{

    private Integer id;
    private String countryName;
    private String countryCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}

