/*
 * module: fundermental
 * file: WordCounter.java
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
 * @create 2018-06-26 09:05
 * @desc 用来在遍历Character流时计数的类
 **/
package com.xlab.service_java_infrastructure.java8chapter7;

public class WordCounter {

    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounter(counter, true);
        } else {
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }
    }

    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.counter,
                wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }
}

