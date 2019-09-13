package com.zjiecode.wxpusher.client;

import com.alibaba.fastjson.JSONObject;
import com.zjiecode.wxpusher.client.bean.Message;
import com.zjiecode.wxpusher.client.bean.Result;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 说明：接口测试
 * 作者：zjiecode
 * 时间：2019-05-03
 */
public class ClientTest {


    @Test
    public void testPost() {
        long start = System.currentTimeMillis();
        Message message = new Message();
        message.setAppToken("AT_qHT0cTQfLwYOlBV9cJj9zDSyEmspsmyM");
        message.setContentType(Message.CONTENT_TYPE_TEXT);
        message.setContent("不加限制的自由是很可怕的，因为很容易让任何人滑向深渊。");
        message.setUid("c1BcpqxEbD8irqlGUh9BhOqR2BvH8yWZ");
        message.setUrl("http://m.baidu.com");
        Result result = WxPusher.send(message);
        System.out.println(JSONObject.toJSONString(result));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }
}
