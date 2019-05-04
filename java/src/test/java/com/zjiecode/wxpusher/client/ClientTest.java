package com.zjiecode.wxpusher.client;

import com.zjiecode.wxpusher.client.model.Message;
import com.zjiecode.wxpusher.client.model.MessageDataValueItem;
import com.zjiecode.wxpusher.client.model.Result;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：接口测试
 * 作者：zjiecode
 * 时间：2019-05-03
 */
public class ClientTest {
    @Test
    public void testGet() {

        List<String> ids = new ArrayList<>();
        ids.add("xxxx");//替换成你的userId，一定不要提交到代码里面了
        Result result = WxPusher.send("nourl", "这个是测试消息", "nourl", ids);
        if (result.isSuccess()) {
            //成功
            System.out.println("发送成功：" + result.getMsg());
        } else {
            //失败
            System.out.println("发送失败：" + result.getMsg());
        }
    }

    @Test
    public void testPost() {
        List<String> ids = new ArrayList<>();
        ids.add("xxxxx");//替换成你的userId，一定不要提交到代码里面了
        Map<String, MessageDataValueItem> data = new HashMap<>();
        data.put("first", new MessageDataValueItem("标题", "#FF0000"));
        data.put("keyword1", new MessageDataValueItem("keyword1", "#000000"));
        data.put("keyword2", new MessageDataValueItem("keyword2", "#000000"));
        data.put("keyword3", new MessageDataValueItem("keyword3", "#000000"));
        data.put("remark", new MessageDataValueItem("remark"));
        Message message = new Message();
        message.setUserIds(ids);
        message.setData(data);
        message.setTemplate_id("lpO9UoVZYGENPpuND3FIofNueSMJZs0DMiU7Bl1eg2c");
        Result result = WxPusher.send(message);
        if (result.isSuccess()) {
            //成功
            System.out.println("发送成功：" + result.getMsg());
        } else {
            //失败
            System.out.println("发送失败：" + result.getMsg());
        }
    }
}
