package com.zjiecode.wxpusher.client.bean;

/**
 * 说明：创建带参数的app临时二维码
 * 作者：zjiecode
 * 时间：2019-09-29
 */
public class CreateQrcodeReq {
    //应用的apptoken
    private String appToken;
    //附带的数据
    private String extra;
    //二维码有效时间，s为单位，最大30天。
    private Integer validTime;

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Integer getValidTime() {
        return validTime;
    }

    public void setValidTime(Integer validTime) {
        this.validTime = validTime;
    }
}
