package com.xlab.service_java_infrastructure.bitcoinj.trigger;

import com.xlab.service_java_infrastructure.bitcoinj.BTCAccountPOJO;
import com.xlab.service_java_infrastructure.bitcoinj.HDWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HDWalletTrigger {

    @Autowired
    private HDWalletService hdWalletServicel;

    @GetMapping("/getAccount")
    public BTCAccountPOJO getAccount() {
       return hdWalletServicel.createBTCAccount();
    }
}
