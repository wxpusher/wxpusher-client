package com.zjiecode.wxpusher.demo.result;

/**
 * 业务异常，一般不是应用的错误，比如：用户登陆没有输入账号
 */
public class BizException extends RuntimeException {
    private ResultCode resultCode;//错误代码

    public BizException() {
    }

    public BizException(String message) {
        super(message);
        this.resultCode = ResultCode.BIZ_FAIL;
    }

    public BizException(String message, ResultCode resultCode) {
        super(message);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setCode(ResultCode code) {
        this.resultCode = code;
    }
}
