package com.zjiecode.wxpusher.demo.result;



/**
 * 应用程序异常异常，比如bug之类的，需要关注
 */
public class AppException extends RuntimeException {
    private ResultCode resultCode;//错误代码

    public AppException() {
    }

    public AppException(String message) {
        super(message);
        this.resultCode = ResultCode.INTERNAL_SERVER_ERROR;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setCode(ResultCode code) {
        this.resultCode = code;
    }
}
