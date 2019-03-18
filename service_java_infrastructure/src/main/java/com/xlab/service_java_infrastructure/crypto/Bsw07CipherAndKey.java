/*
 * module: fundermental
 * file: Bsw07CipherAndKey.java
 * date: 3/14/19 11:21 AM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

package com.xlab.service_java_infrastructure.crypto;

import it.unisa.dia.gas.jpbc.Element;

public class Bsw07CipherAndKey {
    private Bsw07Cipher cipher;
    private Element key;

    public Bsw07CipherAndKey(Bsw07Cipher cipher, Element key) {
        this.cipher = cipher;
        this.key = key;
    }

    public Bsw07Cipher getCipher() {
        return cipher;
    }

    public Element getKey() {
        return key;
    }
}
