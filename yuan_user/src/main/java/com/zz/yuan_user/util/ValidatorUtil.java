package com.zz.yuan_user.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
    private static final Pattern email_pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isEmail(String src){
        if (StringUtils.isNotEmpty(src)){
            Matcher m = email_pattern.matcher(src);
            return m.matches();
        }
        return false;
    }
// test
    public static void main(String[] args) {
        String e = "zhuo9529@gmail.com";
        Matcher m = email_pattern.matcher(e);
        System.out.println(m.matches());
    }
}
