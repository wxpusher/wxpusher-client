package com.zjiecode.wxpusher.client.model;

public class Result {
    //    code错误编码
    //    SUCCESS(200),//成功
    //    BIZ_FAIL(400),//业务异常错误
    //    UNAUTHORIZED(401),//未认证
    //    SIGN_FAIL(402),//签名错误
    //    NOT_FOUND(404),//接口不存在
    //    INTERNAL_SERVER_ERROR(500),//服务器内部错误
    //    WEIXIN_ERROR(600);//和微信交互的过程中发生异常
    private Integer code;
    private String msg;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return code == 200;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}