/**
 * @create 2019-08-26 11:07
 * @desc btc pojo
 **/
package com.xlab.service_java_infrastructure.bitcoinj;

import java.util.List;

public class BTCAccountPOJO {

    private String accountAddress;

    private String secretKey;

    private List<String> mnemonicWord;


    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public List<String> getMnemonicWord() {
        return mnemonicWord;
    }

    public void setMnemonicWord(List<String> mnemonicWord) {
        this.mnemonicWord = mnemonicWord;
    }
}

