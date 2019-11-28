/**
 * @create 2019-08-25 09:51
 * @desc util of HD wallet
 **/
package com.xlab.service_java_infrastructure.bitcoinj.hd;

import com.xlab.service_java_infrastructure.bitcoinj.CoinTypes;
import com.xlab.service_java_infrastructure.bitcoinj.exception.ValidationException;
import io.github.novacrypto.base58.*;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.Utils;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.crypto.HDKeyDerivation;
import org.bitcoinj.crypto.MnemonicException;
import org.bitcoinj.params.MainNetParams;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Keys;

import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class HDUtils {

    private Logger log = LoggerFactory.getLogger(HDUtils.class);

    private static final String PREFIX = "0x";

    //测试链可以用TestNet3Params
    private static final MainNetParams mainnetParams = new MainNetParams();

    /**
     * 随机数列（熵）
     */
    private byte[] entropy;

    /**
     * 助记词
     */
    private List<String> mnemonicWordsInAList;

    /**
     * 种子
     */
    private byte[] seed;

    public HDUtils(){
        Security.addProvider(new BouncyCastleProvider());
        try{
            //生成熵
            RootEntropy rootEntropy = new RootEntropy();
            entropy = rootEntropy.getEntropy();

            //生成助记词
            MnemonicCode mnemonicCode = new MnemonicCode();
            mnemonicWordsInAList = mnemonicCode.toMnemonic(entropy);

            //生成种子
            seed = MnemonicCode.toSeed(mnemonicWordsInAList, "");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据助记词重新生成种子
     * @param words
     */
    private void setSeed(List<String> words){
        //生成种子
        seed = MnemonicCode.toSeed(mnemonicWordsInAList, "");
    }

    /**
     * 生成 BTC 比特币地址（只读钱包）
     * @param addressIndex
     * @param ext_key
     * @return
     */
    public static String getBtcAddress(int addressIndex, String ext_key) {
        DeterministicKey parentDK = DeterministicKey.deserializeB58(ext_key, mainnetParams);
        DeterministicKey childDK = HDKeyDerivation.deriveChildKey(parentDK, addressIndex);
        return childDK.toAddress(mainnetParams).toBase58();
    }

    /**
     * 生成 ETH 以太币地址（只读钱包）
     * @param addressIndex
     * @param ext_key
     * @return
     */
    public static String getEthAddress(int addressIndex, String ext_key) {
        DeterministicKey parentDK = DeterministicKey.deserializeB58(ext_key, mainnetParams);
        DeterministicKey childDK = HDKeyDerivation.deriveChildKey(parentDK, addressIndex);
        ECKey uncompressedChildKey = childDK.decompress();
        //以太坊需要把前缀去掉（0x04前缀表示未压缩）
        String hexK = uncompressedChildKey.getPublicKeyAsHex().substring(2);
        String addr = Keys.getAddress(hexK);

        return PREFIX  + addr;
    }

    /**
     * 生成BTC钱包
     * @throws ValidationException
     */
    public Map<String,Object> createBip44BtcEcKey() throws ValidationException {
        log.info("*************************createBip44BtcEcKey start******************************");

        Map<String,Object> btcMap = new HashMap<String,Object>();
        try {
            ExtendedKey extendedKey = ExtendedKey.create(seed);
            CoinPairDerive coinKeyPair = new CoinPairDerive(extendedKey);

            AddressIndex btcAddress = BIP44.m().purpose49().coinType(CoinTypes.Bitcoin).account(0).external().address(0);
            ECKeyPair ecKeyPairBTC = coinKeyPair.derive(btcAddress);

            btcMap.put("accountAddress",generateSegwitAddress(ecKeyPairBTC.getAddress()));
            //btcMap.put("accountAddress",ecKeyPairBTC.getAddress());
            btcMap.put("publicKey",ecKeyPairBTC.getPublicKey());
            btcMap.put("secretKey",ecKeyPairBTC.getPrivateKey());
            btcMap.put("coinType","BTC");
            btcMap.put("mnemonicWord",this.mnemonicWordsInAList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return btcMap;
    }

    /**
     * 生成ETH钱包
     * @throws ValidationException
     * @throws MnemonicException
     */
    public List<Map<String,Object>> createBip44EthereumEcKey() throws ValidationException, MnemonicException {
        log.info("*************************createBip44EthereumEcKey start******************************");

        List<Map<String,Object>> ethList = new ArrayList<Map<String,Object>>();
        Map<String,Object> ethMap = new HashMap<String,Object>();
        Map<String,Object> mbcMap = new HashMap<String,Object>();
        try {
            ExtendedKey extendedKey = ExtendedKey.create(seed);
            CoinPairDerive coinKeyPair = new CoinPairDerive(extendedKey);

            AddressIndex ethAddress = BIP44.m().purpose44().coinType(CoinTypes.Ethereum).account(0).external().address(0);
            AddressIndex mbcAddress = BIP44.m().purpose44().coinType(CoinTypes.Ethereum).account(0).external().address(1);
            ECKeyPair ecKeyPairETH = coinKeyPair.derive(ethAddress);
            ECKeyPair ecKeyPairMBC = coinKeyPair.derive(mbcAddress);

            ethMap.put("accountAddress",PREFIX + ecKeyPairETH.getAddress());
            ethMap.put("publicKey",ecKeyPairETH.getPublicKey());
            ethMap.put("secretKey",ecKeyPairETH.getPrivateKey());
            ethMap.put("coinType","ETH");
            ethMap.put("mnemonicWord",this.mnemonicWordsInAList);

            mbcMap.put("accountAddress",PREFIX  + ecKeyPairMBC.getAddress());
            mbcMap.put("publicKey",ecKeyPairMBC.getPublicKey());
            mbcMap.put("secretKey",ecKeyPairMBC.getPrivateKey());
            mbcMap.put("coinType","MBC");
            mbcMap.put("mnemonicWord",this.mnemonicWordsInAList);

            ethList.add(ethMap);
            ethList.add(mbcMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ethList;
    }

    /**
     * 生成HD钱包
     * @return
     * @throws ValidationException
     * @throws MnemonicException
     */
    public List<Map<String,Object>> createHDWallet() throws ValidationException, MnemonicException {

        System.out.println("*********************************生成钱包：");
        List<Map<String,Object>> walletList = new ArrayList<Map<String,Object>>();
        Map<String,Object> ethMap = new HashMap<String,Object>();
        Map<String,Object> mbcMap = new HashMap<String,Object>();
        Map<String,Object> btcMap = new HashMap<String,Object>();

        System.out.println("create mnemonicWordsInAList = " + mnemonicWordsInAList);
        byte[] seed = MnemonicCode.toSeed(mnemonicWordsInAList, "");
        System.out.println("create seed = " + seed);
        ExtendedKey extendedKey = ExtendedKey.create(seed);
        CoinPairDerive coinKeyPair = new CoinPairDerive(extendedKey);

        try {
            AddressIndex ethAddress = BIP44.m().purpose44().coinType(CoinTypes.Ethereum).account(0).external().address(0);
            ECKeyPair ecKeyPairETH = coinKeyPair.derive(ethAddress);
            ethMap.put("accountAddress",PREFIX + ecKeyPairETH.getAddress());
            ethMap.put("publicKey",ecKeyPairETH.getPublicKey());
            ethMap.put("secretKey",ecKeyPairETH.getPrivateKey());
            ethMap.put("coinType","ETH");
            ethMap.put("mnemonicWord",this.mnemonicWordsInAList);
            walletList.add(ethMap);

            AddressIndex mbcAddress = BIP44.m().purpose44().coinType(CoinTypes.Ethereum).account(0).external().address(1);
            ECKeyPair ecKeyPairMBC = coinKeyPair.derive(mbcAddress);
            mbcMap.put("accountAddress",PREFIX + ecKeyPairMBC.getAddress());
            mbcMap.put("publicKey",ecKeyPairMBC.getPublicKey());
            mbcMap.put("secretKey",ecKeyPairMBC.getPrivateKey());
            mbcMap.put("coinType","MBC");
            mbcMap.put("mnemonicWord",this.mnemonicWordsInAList);
            walletList.add(mbcMap);

            AddressIndex btcAddress = BIP44.m().purpose49().coinType(CoinTypes.Bitcoin).account(0).external().address(0);
            ECKeyPair ecKeyPairBTC = coinKeyPair.derive(btcAddress);

            btcMap.put("accountAddress",generateSegwitAddress(ecKeyPairBTC.getAddress()));
            //btcMap.put("accountAddress",ecKeyPairBTC.getAddress());
            btcMap.put("publicKey",ecKeyPairBTC.getPublicKey());
            btcMap.put("secretKey",ecKeyPairBTC.getPrivateKey());
            btcMap.put("coinType","BTC");
            btcMap.put("mnemonicWord",this.mnemonicWordsInAList);
            walletList.add(btcMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return walletList;
    }

    /**
     * 助记词导入HD钱包
     * @param mnemonicWordsInAList
     * @return
     * @throws MnemonicException.MnemonicLengthException
     * @throws ValidationException
     */
    public List<Map<String,Object>> importHDWallet(List<String> mnemonicWordsInAList) throws MnemonicException.MnemonicLengthException, ValidationException {
        System.out.println("******************importHDWallet***************导入钱包：");
        List<Map<String,Object>> walletList = new ArrayList<Map<String,Object>>();
        Map<String,Object> ethMap = new HashMap<String,Object>();
        Map<String,Object> mbcMap = new HashMap<String,Object>();
        Map<String,Object> btcMap = new HashMap<String,Object>();

        System.out.println("import mnemonicWordsInAList = " + mnemonicWordsInAList);
        byte[] seed = MnemonicCode.toSeed(mnemonicWordsInAList, "");
        System.out.println("import seed = " + seed);
        ExtendedKey extendedKey = ExtendedKey.create(seed);
        CoinPairDerive coinKeyPair = new CoinPairDerive(extendedKey);

        try {
            AddressIndex ethAddress = BIP44.m().purpose44().coinType(CoinTypes.Ethereum).account(0).external().address(0);
            ECKeyPair ecKeyPairETH = coinKeyPair.derive(ethAddress);
            ethMap.put("accountAddress",PREFIX + ecKeyPairETH.getAddress());
            ethMap.put("publicKey",ecKeyPairETH.getPublicKey());
            ethMap.put("secretKey",ecKeyPairETH.getPrivateKey());
            ethMap.put("coinType","ETH");
            walletList.add(ethMap);

            AddressIndex mbcAddress = BIP44.m().purpose44().coinType(CoinTypes.Ethereum).account(0).external().address(1);
            ECKeyPair ecKeyPairMBC = coinKeyPair.derive(mbcAddress);
            mbcMap.put("accountAddress",PREFIX  + ecKeyPairMBC.getAddress());
            mbcMap.put("publicKey",ecKeyPairMBC.getPublicKey());
            mbcMap.put("secretKey",ecKeyPairMBC.getPrivateKey());
            mbcMap.put("coinType","MBC");
            walletList.add(mbcMap);

            AddressIndex btcAddress = BIP44.m().purpose49().coinType(CoinTypes.Bitcoin).account(0).external().address(0);
            ECKeyPair ecKeyPairBTC = coinKeyPair.derive(btcAddress);

            btcMap.put("accountAddress",generateSegwitAddress(ecKeyPairBTC.getAddress()));
            //btcMap.put("accountAddress",ecKeyPairBTC.getAddress());
            btcMap.put("publicKey",ecKeyPairBTC.getPublicKey());
            btcMap.put("secretKey",ecKeyPairBTC.getPrivateKey());
            btcMap.put("coinType","BTC");
            walletList.add(btcMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return walletList;
    }

    /**
     * 助记词导入BTC钱包
     * @param mnemonicWordsInAList
     * @return
     * @throws MnemonicException.MnemonicLengthException
     * @throws ValidationException
     */
    public Map<String,Object> importBTCWallet(List<String> mnemonicWordsInAList) throws MnemonicException.MnemonicLengthException, ValidationException {
        System.out.println("******************importBTCWallet***************导入钱包：");
        Map<String,Object> btcMap = new HashMap<String,Object>();

        byte[] seed = MnemonicCode.toSeed(mnemonicWordsInAList, "");
        ExtendedKey extendedKey = ExtendedKey.create(seed);
        CoinPairDerive coinKeyPair = new CoinPairDerive(extendedKey);

        try {
            AddressIndex btcAddress = BIP44.m().purpose49().coinType(CoinTypes.Bitcoin).account(0).external().address(0);
            ECKeyPair ecKeyPairBTC = coinKeyPair.derive(btcAddress);

            btcMap.put("accountAddress",generateSegwitAddress(ecKeyPairBTC.getAddress()));
            btcMap.put("publicKey",ecKeyPairBTC.getPublicKey());
            btcMap.put("secretKey",ecKeyPairBTC.getPrivateKey());
            btcMap.put("coinType","BTC");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return btcMap;
    }

    /**
     * 私钥导入BTC钱包
     * @param privateKey
     * @return
     */
    public Map<String,Object> importBTCWallet(String privateKey){
        System.out.println("******************importBTCWallet***************导入钱包：");
        Map<String,Object> btcMap = new HashMap<String,Object>();

        try {
            BitCoinECKeyPair bitCoinECKeyPair = BitCoinECKeyPair.parseWIF(privateKey);
            btcMap.put("accountAddress",generateSegwitAddress(bitCoinECKeyPair.getAddress()));
            btcMap.put("publicKey",bitCoinECKeyPair.getPublicKey());
            btcMap.put("secretKey",bitCoinECKeyPair.getPrivateKey());
            btcMap.put("coinType","BTC");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return btcMap;
    }

    /**
     * 校验助记词
     * @param mnemonicWordsInAList
     * @throws Exception
     */
    public int check(List<String> mnemonicWordsInAList) throws Exception{
        MnemonicCode mnemonicCode = new MnemonicCode();
        return mnemonicCode.checkTheWords(mnemonicWordsInAList);
    }

    /**
     * 生成隔离见证地址
     * @param address
     * @return
     */
    private String generateSegwitAddress(String address) {
        byte[] decoded = Utils.parseAsHexOrBase58(address);
        // We should throw off header byte that is 0 for Bitcoin (Main)
        byte[] pureBytes = new byte[20];
        System.arraycopy(decoded, 1, pureBytes, 0, 20);
        // Than we should prepend the following bytes:
        byte[] scriptSig = new byte[pureBytes.length + 2];
        scriptSig[0] = 0x00;
        scriptSig[1] = 0x14;
        System.arraycopy(pureBytes, 0, scriptSig, 2, pureBytes.length);
        byte[] addressBytes = org.bitcoinj.core.Utils.sha256hash160(scriptSig);
        // Here are the address bytes
        byte[] readyForAddress = new byte[addressBytes.length + 1 + 4];
        // prepending p2sh header:
        readyForAddress[0] = (byte) 5;
        System.arraycopy(addressBytes, 0, readyForAddress, 1, addressBytes.length);
        // But we should also append check sum:
        byte[] checkSum = Sha256Hash.hashTwice(readyForAddress, 0, addressBytes.length + 1);
        System.arraycopy(checkSum, 0, readyForAddress, addressBytes.length + 1, 4);
        // To get the final address:
        String segwitAddress = io.github.novacrypto.base58.Base58.base58Encode(readyForAddress);
        System.out.println("segwit address:" + segwitAddress);

        return segwitAddress;
    }

    public static void main(String []args){
        HDUtils hdWalletUtils = new HDUtils();

        int addressIndex = 0;
        String ext_key = "xprv9s21ZrQH143K2yg6QpYU8aPKBR4KkwRoM1wb8TpFZv1siBddcEgLo7sx58KbAyETJ8Z7hozpUmbtbZWfLYVpDBUKgQW8E9W4DXSgmaVw9xb";
        String btcAddress = HDUtils.getBtcAddress(addressIndex,ext_key);
        //System.out.println("btcAddress = " + btcAddress);

        //ext_key = "m/44'/60'/0'/0";
        String ethAddres = HDUtils.getEthAddress(addressIndex,ext_key);
        String mbcAddres = HDUtils.getEthAddress(addressIndex + 1,ext_key);
        //System.out.println("ethAddres = " + ethAddres);
        //System.out.println("mbcAddres = " + mbcAddres);

        try{
            System.out.println("*****************生成钱包：");
/*            Map<String,Object> btcMap = hdWalletUtils.createBip44BtcEcKey();
            List<Map<String,Object>> ethList = hdWalletUtils.createBip44EthereumEcKey();

            if(null != btcMap && null != ethList){
                ethList.add(btcMap);
            }

            System.out.println(ethList.toString());*/

            System.out.println("*****************导入钱包：");
            //hdWalletUtils.importBip44BtcEcKey(hdWalletUtils.mnemonicWordsInAList);
            //hdWalletUtils.impertBip44EthereumEcKey(hdWalletUtils.mnemonicWordsInAList);

            //exportPrivateKey("F:\\ethererum_chain\\derive\\UTC--2018-10-22T05-49-38.18000000Z--3048c27d42153c71a967420c2605363e143fe80d.json", "123456");
            //testbip44EthereumEcKey();

            //String testAddress = hdWalletUtils.generateSegwitAddress("13mW4K2AVjEdJEVgvyPn4418KcFVWPZv7V");
            //System.out.println("testAddress = " + testAddress);

            String privateKey = "L36UqTY34m9GhBuXwyA64tHcxuuZohv2bovU87nx8VRwwnSj75q7";
            BitCoinECKeyPair bitCoinECKeyPair = BitCoinECKeyPair.parseWIF(privateKey);
            String thisAddress = bitCoinECKeyPair.getAddress();
            System.out.println("thisAddress = " + thisAddress);
            System.out.println("segwitAddress = " + hdWalletUtils.generateSegwitAddress(thisAddress));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static String generateSegwitAddress2(byte[] decoded) {
        //byte[] decoded = Utils.parseAsHexOrBase58(address);
        // We should throw off header byte that is 0 for Bitcoin (Main)
        byte[] pureBytes = new byte[20];
        System.arraycopy(decoded, 1, pureBytes, 0, 20);
        // Than we should prepend the following bytes:
        byte[] scriptSig = new byte[pureBytes.length + 2];
        scriptSig[0] = 0x00;
        scriptSig[1] = 0x14;
        System.arraycopy(pureBytes, 0, scriptSig, 2, pureBytes.length);
        byte[] addressBytes = org.bitcoinj.core.Utils.sha256hash160(scriptSig);
        // Here are the address bytes
        byte[] readyForAddress = new byte[addressBytes.length + 1 + 4];
        // prepending p2sh header:
        readyForAddress[0] = (byte) 5;
        System.arraycopy(addressBytes, 0, readyForAddress, 1, addressBytes.length);
        // But we should also append check sum:
        byte[] checkSum = Sha256Hash.hashTwice(readyForAddress, 0, addressBytes.length + 1);
        System.arraycopy(checkSum, 0, readyForAddress, addressBytes.length + 1, 4);
        // To get the final address:
        String segwitAddress = io.github.novacrypto.base58.Base58.base58Encode(readyForAddress);
        System.out.println("segwit address:" + segwitAddress);

        return segwitAddress;
    }
}

