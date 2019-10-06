package com.zjiecode.wxpusher.client;

import com.alibaba.fastjson.JSONObject;
import com.zjiecode.wxpusher.client.bean.Result;

import org.junit.Test;

/**
 * 说明：接口测试
 * 作者：zjiecode
 * 时间：2019-05-03
 */
public class ClientTest {


    @Test
    public void testQuery() {
        long start = System.currentTimeMillis();
        Result result = WxPusher.queryMessageStatus(9L);
        System.out.println(JSONObject.toJSONString(result));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }
}
