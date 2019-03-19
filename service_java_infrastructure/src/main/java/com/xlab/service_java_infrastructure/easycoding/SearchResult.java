/*
 * module: fundermental
 * file: SearchResult.java
 * date: 3/19/19 3:41 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-19 15:41
 * @desc test of comparable interface
 *
 * test of compare with same type
 **/
package com.xlab.service_java_infrastructure.easycoding;

public class SearchResult implements Comparable<SearchResult>{

     int relativeRadio;
     long count;
     int recentOrderders;

    SearchResult(int relativeRadio,long count) {
        this.relativeRadio = relativeRadio;
        this.count = count;
    }

    // if object is bigger than the given object will return 1
    // if object is smaller than the given object will return -1
    // if object equals the given object will return 0
    @Override
    public int compareTo(SearchResult o) {

        if (this.relativeRadio != o.relativeRadio) {
            return this.relativeRadio > o.relativeRadio? 1:-1;
        }

        if (this.count != o.count) {
            return this.count > o.count? 1:-1;
        }

        return 0;
    }

    public void setRecentOrderders(int recentOrderders) {
        this.recentOrderders = recentOrderders;
    }
}

