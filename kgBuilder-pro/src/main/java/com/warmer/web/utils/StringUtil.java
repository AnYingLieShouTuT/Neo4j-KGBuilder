package com.warmer.web.utils;

public class StringUtil {

    /**
     * 按照逗号，分割字符串，并返回分割后的字符串数组
     *
     * @param s 要分割的字符串
     * @return 分割后的字符串数组
     */
    public static String[] splitWithComma(String s) {
        return s.split(",");
    }

    /**
     * 按照指定分隔符，分割字符串，并返回分割后的字符串数组
     *
     * @param s     要分割的字符串
     * @param regex 指定的分隔符
     * @return 分割后的字符串数组
     */
    public static String[] split(String s, String regex) {
        return s.split(regex);
    }

}