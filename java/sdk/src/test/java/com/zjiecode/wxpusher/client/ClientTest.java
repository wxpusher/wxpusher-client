package com.zjiecode.wxpusher.client;

import com.alibaba.fastjson.JSONObject;
import com.zjiecode.wxpusher.client.bean.Page;
import com.zjiecode.wxpusher.client.bean.Result;
import com.zjiecode.wxpusher.client.bean.WxUser;

import org.junit.Test;

/**
 * 说明：接口测试
 * 作者：zjiecode
 * 时间：2019-05-03
 */
public class ClientTest {


    @Test
    public void testQuery() {
        Result<Page<WxUser>> wxUsers = WxPusher.queryWxUser("AT_mNerlsGVCvwqLbS7vYo4JBfk8fEFLKgC", 1, 2);
        System.out.println(JSONObject.toJSONString(wxUsers));
        wxUsers.getData().getRecords().forEach(d-> System.out.println(d.getUid()));
    }
}
