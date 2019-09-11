package com.zjiecode.wxpusher.client.bean;

/**
 * 返回编码,参考http语义
 */
public enum ResultCode {
    SUCCESS(1000),//成功
    BIZ_FAIL(1001),//业务异常错误
    UNAUTHORIZED(1002),//未认证
    SIGN_FAIL(1003),//签名错误
    NOT_FOUND(1004),//接口不存在
    INTERNAL_SERVER_ERROR(1005),//服务器内部错误
    WEIXIN_ERROR(1006),//和微信交互的过程中发生异常
    NETWORK_ERROR(1007),//网络异常
    DATA_ERROR(1008),//数据异常
    UNKNOWN_ERROR(1009),//未知异常
    ;

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}