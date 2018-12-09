package com.zz.yuan_user.redis;

public class UserKey extends BasePrefix {

    private UserKey(String prefix) {
        super(prefix);
    }

    private UserKey(int expireSecond, String prefix) {
        super(expireSecond, prefix);
    }

    public static UserKey token = new UserKey(6000,"tk");
}
