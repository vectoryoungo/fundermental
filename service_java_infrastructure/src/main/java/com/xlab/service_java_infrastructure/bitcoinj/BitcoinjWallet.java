package com.xlab.service_java_infrastructure.bitcoinj;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.params.RegTestParams;
import org.bitcoinj.params.TestNet3Params;

/**
 * NetworkParameters: instance which selects the network (production or test) you are on.
 * Wallet:  instance to store your ECKeys and other data.
 * PeerGroup: instance to manage the network connections.
 * BlockChain: instance which manages the shared, global data structure which makes Bitcoin work.
 * BlockStore: instance which keeps the block chain data structure somewhere, like on disk.
 * WalletEventListener: implementations, which receive wallet events.
 * WalletAppKit: To simplify setting them up,a WalletAppKit object that creates the above objects and connects them together.
 */
public class BitcoinjWallet {


    public static void main(String[] args) {

        // Figure out which network we should connect to. Each one gets its own set of files.
        NetworkParameters params;
        String filePrefix;
        if (args[1].equals("testnet")) {
            // test network :will be reset from time to time
            params = TestNet3Params.get();
            filePrefix = "forwarding-service-testnet";
        } else if (args[1].equals("regtest")) {
            params = RegTestParams.get();
            filePrefix = "forwarding-service-regtest";
        } else {
            params = MainNetParams.get();
            filePrefix = "forwarding-service";
        }
    }

}
