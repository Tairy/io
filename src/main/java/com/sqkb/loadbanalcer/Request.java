package com.sqkb.loadbanalcer;

import java.io.InputStream;

/**
 * package: com.sqkb.loadbanalcer
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/29 下午9:53
 */
public class Request {

    private final long transactionId;

    private final int transactionType;

    private InputStream in;

    public Request(long transactionId, int transactionType) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public InputStream getIn() {
        return in;
    }

    public void setIn(InputStream in) {
        this.in = in;
    }
}