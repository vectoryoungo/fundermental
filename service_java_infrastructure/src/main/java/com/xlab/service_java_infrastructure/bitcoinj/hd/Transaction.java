package com.xlab.service_java_infrastructure.bitcoinj.hd;


import com.xlab.service_java_infrastructure.bitcoinj.exception.ValidationException;

public interface Transaction {
    byte[] sign(ECKeyPair key) throws ValidationException;

    public byte[] getSignBytes();

    /**
     * Eth 使用的方法
     *
     * @return
     */
    public byte[] getData();


}
