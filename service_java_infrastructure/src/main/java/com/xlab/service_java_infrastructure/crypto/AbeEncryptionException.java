/*
 * module: fundermental
 * file: AbeEncryptionException.java
 * date: 3/14/19 11:27 AM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

package com.xlab.service_java_infrastructure.crypto;

import java.security.GeneralSecurityException;

public class AbeEncryptionException extends GeneralSecurityException {

    private static final long serialVersionUID = 1043863535572140323L;

    public AbeEncryptionException(String msg) {
        super(msg);
    }

    public AbeEncryptionException(String msg, Throwable t) {
        super(msg, t);
    }

}
