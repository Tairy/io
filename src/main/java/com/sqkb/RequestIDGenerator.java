package com.sqkb;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * package: com.sqkb
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/11/29 上午11:46
 */
public class RequestIDGenerator {

    private final static RequestIDGenerator INSTANCE = new RequestIDGenerator();

    private final static short SEQ_UPPER_LIMIT = 999;

    private short sequence = -1;

    private RequestIDGenerator() {
    }

    public synchronized short nextSequence() {
        if (sequence >= SEQ_UPPER_LIMIT) {
            sequence = 0;
        } else {
            sequence++;
        }
        return sequence;
    }

    public String nextId() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
        String timestamp = simpleDateFormat.format(new Date());
        DecimalFormat format = new DecimalFormat("000");
        short seqNo = nextSequence();
        return "0049" + timestamp + format.format(seqNo);
    }

    public static RequestIDGenerator getInstance() {
        return INSTANCE;
    }
}