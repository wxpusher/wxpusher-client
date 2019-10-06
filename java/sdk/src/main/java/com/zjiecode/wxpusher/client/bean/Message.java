package com.zjiecode.wxpusher.client.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 说明：
 * 作者：zjiecode
 * 时间：2019-09-05
 */
public class Message {
    /**
     * 1:text，可以直接显示在卡片里面
     * 2:html，点击以后查看，支持html
     * 3:md，markdown格式，和html类似
     */
    public static final int CONTENT_TYPE_TEXT = 1;
    public static final int CONTENT_TYPE_HTML = 2;
    public static final int CONTENT_TYPE_MD = 3;

    private String appToken;

    //发送的目标
    private Set<String> uids;
    private Set<Long> topicIds;

    private Integer contentType;

    private String content;

    /**
     * 仅针对text消息类型有效
     */
    private String url;

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public Set<String> getUids() {
        return uids;
    }

    public void setUid(String uid) {
        this.uids = new HashSet<>(1);
        this.uids.add(uid);
    }

    public void setTopicId(Long topicId) {
        this.topicIds = new HashSet<>(1);
        this.topicIds.add(topicId);
    }

    public void setUids(Set<String> uids) {
        this.uids = uids;
    }

    public Set<Long> getTopicIds() {
        return topicIds;
    }

    public void setTopicIds(Set<Long> topicIds) {
        this.topicIds = topicIds;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    /**
     * 只需要 body 标签内部的内容。
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
