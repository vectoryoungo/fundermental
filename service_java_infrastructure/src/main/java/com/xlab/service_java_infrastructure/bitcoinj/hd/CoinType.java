package com.xlab.service_java_infrastructure.bitcoinj.hd;


import com.xlab.service_java_infrastructure.bitcoinj.CoinTypes;

public class CoinType {
    private final Purpose purpose;
    private final CoinTypes coinType;
    private final String string;

    CoinType(final Purpose purpose, final CoinTypes coinType) {
        this.purpose = purpose;
        this.coinType = coinType;
        string = String.format("%s/%d'", purpose, coinType.coinType());
    }

    public CoinTypes getValue() {
        return coinType;
    }

    public Purpose getParent() {
        return purpose;
    }

    @Override
    public String toString() {
        return string;
    }

    /**
     * Create a {@link Account} for this purpose and coin type.
     *
     * @param account The account number
     * @return An {@link Account} instance for this purpose and coin type
     */
    public Account account(final int account) {
        return new Account(this, account);
    }
}
