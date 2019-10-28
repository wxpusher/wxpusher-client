package com.zjiecode.wxpusher.client;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zjiecode.wxpusher.client.bean.CreateQrcodeReq;
import com.zjiecode.wxpusher.client.bean.CreateQrcodeResp;
import com.zjiecode.wxpusher.client.bean.Message;
import com.zjiecode.wxpusher.client.bean.MessageResult;
import com.zjiecode.wxpusher.client.bean.Page;
import com.zjiecode.wxpusher.client.bean.Result;
import com.zjiecode.wxpusher.client.bean.ResultCode;
import com.zjiecode.wxpusher.client.bean.WxUser;

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
        if (messageId == null || messageId <= 0) {
            return new Result(ResultCode.BIZ_FAIL, "messageId为空");
        }
        return HttpUtils.get(String.format("/api/send/query/%s", messageId));
    }

    /**
     * 创建带参数的app临时二维码
     */
    public static Result<CreateQrcodeResp> createAppTempQrcode(CreateQrcodeReq createQrcodeReq) {
        Result result = HttpUtils.post(createQrcodeReq, "/api/fun/create/qrcode");
        if (result.getData() != null) {
            String jsonString = JSONObject.toJSONString(result.getData());
            CreateQrcodeResp createQrcodeResp = JSONObject.parseObject(jsonString, CreateQrcodeResp.class);
            result.setData(createQrcodeResp);
        }
        return result;
    }

    /**
     * 查询关注你App的微信用户
     *
     * @param appToken 应用token
     * @param page     页码
     * @param pageSize 分页大小
     * @return 查询的数据
     */
    public static Result<Page<WxUser>> queryWxUser(String appToken, Integer page, Integer pageSize) {
        if (appToken == null || appToken.isEmpty()) {
            return new Result(ResultCode.BIZ_FAIL, "appToken不能为空");
        }
        if (page == null || page <= 0) {
            return new Result(ResultCode.BIZ_FAIL, "page不合法");
        }
        if (page == null || page <= 0) {
            return new Result(ResultCode.BIZ_FAIL, "pageSize不合法");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("appToken", appToken);
        params.put("page", page);
        params.put("pageSize", pageSize);
        Result result = HttpUtils.get(params, "/api/fun/wxuser");
        if (result.getData() != null) {
            String jsonString = JSONObject.toJSONString(result.getData());
            Page pageData = JSONObject.parseObject(jsonString, new TypeReference<Page<WxUser>>() {
            });
            result.setData(pageData);
        }
        return result;
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
