/**
 * @create 2019-08-26 11:09
 * @desc implement of HDWalletService
 **/
package com.xlab.service_java_infrastructure.bitcoinj;

import com.xlab.service_java_infrastructure.bitcoinj.exception.ValidationException;
import com.xlab.service_java_infrastructure.bitcoinj.hd.HDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class HDWalletServiceImpl implements HDWalletService{

    private static final Logger log = LoggerFactory.getLogger(HDWalletServiceImpl.class);

    @Autowired
    private HDUtils hdUtils;

    @Override
    public BTCAccountPOJO createBTCAccount() {
        BTCAccountPOJO btcAccountPOJO = null;

        try {
            //HDUtils hdUtils = new HDUtils();
            Map<String,Object> btcAddress = hdUtils.createBip44BtcEcKey();
            String privateKey = (String) btcAddress.get("secretKey");
            List<String> mnemonicWord = (List<String>) btcAddress.get("mnemonicWord");
            String address = (String) btcAddress.get("accountAddress");
            btcAccountPOJO = new BTCAccountPOJO();
            btcAccountPOJO.setAccountAddress(address);
            btcAccountPOJO.setMnemonicWord(mnemonicWord);
            btcAccountPOJO.setSecretKey(privateKey);
        } catch (ValidationException e) {
            log.error("error createBTCAccount [{}] ",e);
        }

        return btcAccountPOJO;
    }
}

