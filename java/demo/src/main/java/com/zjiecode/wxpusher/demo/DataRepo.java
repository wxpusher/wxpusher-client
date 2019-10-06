package com.zjiecode.wxpusher.demo;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * 说明：缓存一下数据，demo就不用数据库了
 *
 * 作者：zjiecode
 * 时间：2019-10-05
 */
@Slf4j
public class DataRepo {
    private static Map<String, String> data = new HashMap();

    public static void put(String key, String value) {
        data.put(key, value);
    }

    public static String get(String key) {
        return data.get(key);
    }

    public static void remove(String key) {
        data.remove(key);
    }

    public static void clear() {
        data.clear();
    }
}
