package com.ssm.test;

import java.util.Locale;

public class LocaleTest {
    public static void main(String[] args) {
        Locale locale = new Locale("zh-CN", "华 -中国");
        String displayLanguage = locale.getDisplayLanguage();
        System.out.println(displayLanguage);
        String s = locale.toString();
        System.out.println(s);

    }
}
