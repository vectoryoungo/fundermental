package com.xlab.service_java_infrastructure.bitcoinj;

import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.params.RegTestParams;
import org.bitcoinj.params.TestNet3Params;

import java.io.File;

/**
 * NetworkParameters: instance which selects the network (production or test) you are on.
 * Wallet:  instance to store your ECKeys and other data.
 * PeerGroup: instance to manage the network connections.
 * BlockChain: instance which manages the shared, global data structure which makes Bitcoin work.
 * BlockStore: instance which keeps the block chain data structure somewhere, like on disk.
 * WalletEventListener: implementations, which receive wallet events.
 * WalletAppKit: To simplify setting them up,a WalletAppKit object that creates the above objects and connects them together.
 *
 * A typical application that wants to send and receive money needs at least
 * a BlockChain,
 * a BlockStore,
 * a PeerGroup and a Wallet.
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

        WalletAppKit walletAppKit = new WalletAppKit(params, new File("."), filePrefix) {
            @Override
            protected void onSetupCompleted() {
                // This is called in a background thread after startAndWait is called, as setting up various objects
                // can do disk and network IO that may cause UI jank/stuttering in wallet apps if it were to be done
                // on the main thread.
                if (wallet().getKeyChainGroupSize() < 1)
                    wallet().importKey(new ECKey());
            }
        };

        if (params == RegTestParams.get()) {
            // Regression test mode is designed for testing and development only, so there's no public network for it.
            // If you pick this mode, you're expected to be running a local "bitcoind -regtest" instance.
            walletAppKit.connectToLocalHost();
        }

        // Download the block chain and wait until it's done.
        walletAppKit.startAsync();
        walletAppKit.awaitRunning();
    }

}
