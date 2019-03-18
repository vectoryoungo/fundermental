/*
 * module: fundermental
 * file: Java8FileFilterSimlator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

/*
 * module: ${PROJECT_NAME}
 * file: ${FILE_NAME}
 * date: ${DATE}
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-16 17:36
 * @desc demo of file filter in java8
 **/
package com.xlab.service_java_infrastructure.java8chapter1;

import java.io.File;

public class Java8FileFilterSimlator {

    public static void main(String[] args) {

        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        System.out.println(" hidden file size " + hiddenFiles.length);
        for (File file:hiddenFiles) {
            System.out.println(" file name :" + file.getName());
            System.out.println(" isHidden :" + file.isHidden());
        }
    }
}

