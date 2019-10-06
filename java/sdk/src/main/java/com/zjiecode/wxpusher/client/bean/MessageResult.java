package com.zjiecode.wxpusher.client.bean;

/**
 * 说明：
 * 作者：zjiecode
 * 时间：2019-09-23
 */
public class MessageResult {
    private String uid;
    private String status;
    private Integer code;
    private Long messageId;

    /**
     * 消息是否发送成功
     * @return
     */
    public boolean isSuccess() {
        return code == ResultCode.SUCCESS.getCode();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
}
