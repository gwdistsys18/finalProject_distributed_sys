package com.zz.yuan_user.redis;

public class OrderKey extends BasePrefix {

    private OrderKey(int expireSecond, String prefix) {
        super(expireSecond, prefix);
    }
}
