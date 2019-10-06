package com.zjiecode.wxpusher.client.bean;

/**
 * 说明：创建带参数的app临时二维码
 * 作者：zjiecode
 * 时间：2019-09-29
 */
public class CreateQrcodeResp {
    private long expires;
    private String code;
    private String shortUrl;
    private String url;
    private String extra;

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
