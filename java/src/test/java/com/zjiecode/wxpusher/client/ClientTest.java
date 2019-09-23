package com.zjiecode.wxpusher.client;

import com.alibaba.fastjson.JSONObject;
import com.zjiecode.wxpusher.client.bean.Message;
import com.zjiecode.wxpusher.client.bean.MessageResult;
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
        message.setAppToken("AT_RPux8jzr6GBz1hQXQerA5HNqtibnXFX7");
        message.setContentType(Message.CONTENT_TYPE_HTML);
        message.setContent("<a hre> afa</a> aadf<span style=\"color:red;\">加油</span>");
        message.setUid("UID_yXQrHxtg1Qzdbf6Zox83izUXPyKG");
        message.setUrl("http://m.baidu.com");
        Result<List<MessageResult>> result = WxPusher.send(message);
        List<MessageResult> data = result.getData();
        for (int i = 0; i < data.size(); i++) {
            String msg = WxPusher.queryMessageStatus(data.get(i).getMessageId()).getMsg();
            System.out.println(msg);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

    @Test
    public void testQuery() {
        long start = System.currentTimeMillis();
        Result result = WxPusher.queryMessageStatus(9L);
        System.out.println(JSONObject.toJSONString(result));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }
}
