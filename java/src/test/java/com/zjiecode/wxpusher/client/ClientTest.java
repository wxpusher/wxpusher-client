package com.zjiecode.wxpusher.client;

import com.zjiecode.wxpusher.client.bean.Message;
import com.zjiecode.wxpusher.client.bean.Result;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：接口测试
 * 作者：zjiecode
 * 时间：2019-05-03
 */
public class ClientTest {


    @Test
    public void testPost() {
        Message message = new Message();
        message.setAppToken("AT_qHT0cTQfLwYOlBV9cJj9zDSyEmspsmyM");
        message.setContentType(Message.CONTENT_TYPE_TEXT);
        message.setContent("测试一下，这是一个非常牛皮的事情");
        message.setUid("c1BcpqxEbD8irqlGUh9BhOqR2BvH8yWZ");
//        message.setUrl("http://m.baidu.com");
        Result result = WxPusher.send(message);
        System.out.println("结果:" + result.getMsg() + ",消息ID：" + result.getData());
    }
}
