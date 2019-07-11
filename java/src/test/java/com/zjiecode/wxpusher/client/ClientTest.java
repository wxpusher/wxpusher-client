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
//        List<String> ids = new ArrayList<>();
//        ids.add("xxx");//替换成你的userId，一定不要提交到代码里面了

        Result result = WxPusher.post("标题","消息内容","http://m.meituan.com","xxx");
        if (result.isSuccess()) {
            //成功
            System.out.println("发送成功：" + result.getMsg());
        } else {
            //失败
            System.out.println("发送失败：" + result.getMsg());
        }
    }
}
