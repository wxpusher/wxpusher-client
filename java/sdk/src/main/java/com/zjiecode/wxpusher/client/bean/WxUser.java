package com.zjiecode.wxpusher.client.bean;

/**
 * 说明：微信用户数据
 * 作者：zjiecode
 * 时间：2019-10-28
 */
public class WxUser {

    //UID，用户标志
    private String uid;

    //用户是否接收消息，也就是是否打开了消息开关
    private Boolean enable;

    //用户关注应用的时间
    private Long createTime;

    //昵称
    private String nickName;

    //头像
    private String headImg;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
