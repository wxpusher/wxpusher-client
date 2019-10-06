package com.zjiecode.wxpusher.demo.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 说明：获取随机数
 * 作者：zjiecode
 * 时间：2019-05-11
 */
public class RandomUtil {
    private static String STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * 获取随机的数字
     */
    public static String getRandomNumber(int len) {
        StringBuilder stringBuilder = new StringBuilder(len);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    /**
     * 随机生成字符串
     */
    public static String getRandomStr(int len) {
        StringBuilder stringBuilder = new StringBuilder(len);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(STRING.charAt(random.nextInt(STRING.length())));
        }
        return stringBuilder.toString();
    }
}
