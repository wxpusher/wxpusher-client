package com.zjiecode.wxpusher.client;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zjiecode.wxpusher.client.bean.Message;
import com.zjiecode.wxpusher.client.bean.MessageResult;
import com.zjiecode.wxpusher.client.bean.Result;
import com.zjiecode.wxpusher.client.bean.ResultCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：WxPusher的客户端
 * 作者：zjiecode
 * 时间：2019-05-03
 */
public final class WxPusher {
    private WxPusher() {
    }

    /**
     * 发送消息
     */
    public static Result<List<MessageResult>> send(Message message) {
        Result result = verify(message);
        if (result != null) {
            return result;
        }
        Result sendResult = HttpUtils.post(message, "/api/send/message");
        if (sendResult.isSuccess()) {
            //转换，方便调用
            Object data = sendResult.getData();
            String s = JSONObject.toJSONString(data);
            List<MessageResult> messageResults = JSONObject.parseObject(s, new TypeReference<List<MessageResult>>() {
            });
            sendResult.setData(messageResults);
        }
        return sendResult;
    }

    /**
     * 查询消息发送状态
     */
    public static Result queryMessageStatus(Long messageId) {
        return HttpUtils.get(String.format("/api/send/query/%s", messageId));
    }


    /**
     * 验证消息合法性，客户端验证比较宽松，主要在服务端进行校验
     */
    private static Result verify(Message message) {
        if (message == null) {
            return new Result(ResultCode.BIZ_FAIL, "消息不能为空");
        }
        if (message.getAppToken() == null || message.getAppToken().length() <= 0) {
            return new Result(ResultCode.BIZ_FAIL, "appToken不能为空");
        }
        if (message.getContent() == null || message.getContent().length() <= 0) {
            return new Result(ResultCode.BIZ_FAIL, "content内容不能为空");
        }
        return null;
    }
}
