package com.zjiecode.wxpusher.client;

import com.sun.istack.internal.NotNull;
import com.zjiecode.wxpusher.client.bean.Message;
import com.zjiecode.wxpusher.client.bean.Result;
import com.zjiecode.wxpusher.client.bean.ResultCode;

/**
 * 说明：WxPusher的客户端
 * 作者：zjiecode
 * 时间：2019-05-03
 */
public final class WxPusher {
    private WxPusher() {
    }

    public static @NotNull Result send(@NotNull Message message) {
        Result result = verify(message);
        if (result != null) {
            return result;
        }
        return HttpUtils.post(message,"/api/send/message");
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
