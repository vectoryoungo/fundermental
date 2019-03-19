/*
 * module: fundermental
 * file: SearchResultComparator.java
 * date: 3/19/19 3:54 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-19 15:53
 * @desc test no modify implement comparable but adapt it
 **/
package com.xlab.service_java_infrastructure.easycoding;

import java.util.Comparator;

public class SearchResultComparator implements Comparator<SearchResult>{

    @Override
    public int compare(SearchResult o1, SearchResult o2) {

        if (o1.relativeRadio != o2.relativeRadio){

            return o1.relativeRadio > o2.relativeRadio ? 1:-1;
        }

        if (o1.recentOrderders != o2.recentOrderders) {
            return o1.recentOrderders > o2.recentOrderders ? 1:-1;
        }

        if (o1.count != o2.count) {
            return o1.count > o2.count ? 1:-1;
        }

        return 0;
    }
}

