package com.zjiecode.wxpusher.client.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 说明：发送消息的实体
 * 作者：zjiecode
 * 时间：2019-05-03
 */
public class Message {

    private List<String> userIds;
    private String template_id;
    private String url;
    private Map<String, MessageDataValueItem> data;

    public List<String> getUserIds() {
        return userIds;
    }

    /**
     * 接收者的 userId
     *
     * @param userIds 用户id的列表
     */
    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public String getTemplate_id() {
        return template_id;
    }

    /**
     * 设置模版id，你可以在官网查看：http://wxpusher.dingliqc.com/#part-4
     *
     * @param templateId 模版id
     */
    public void setTemplate_id(String templateId) {
        this.template_id = templateId;
    }

    public String getUrl() {
        return url;
    }

    /**
     * 设置url，不设置会给一个默认的可以复制消息的url，不需要你可以强制设置为"nourl"
     *
     * @param url 在微信点击的打开的url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, MessageDataValueItem> getData() {
        return data;
    }

    /**
     * 填充消息模板里面的空，不同消息模板，包含的字段不一样
     *
     * @param data 填充模版的数据
     */
    public void setData(Map<String, MessageDataValueItem> data) {
        this.data = data;
    }

    /**
     * 验证消息格式
     *
     * @return 返回出错信息，如果没有出错返回null
     */
    public String valid() {
        if (userIds == null || userIds.isEmpty()) {
            return "发送人不能为空";
        } else if (template_id == null || template_id.isEmpty()) {
            return "消息模版不能为空";
        } else if (data == null || data.isEmpty()) {
            return "消息不能为空";
        } else if (!data.containsKey("first") || !data.containsKey("remark")) {
            return "消息结构不合法，请仔细阅读接口文档";
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("userIds=[");
        if (userIds == null || userIds.isEmpty()) {
            sb.append("null");
        } else {
            userIds.stream().forEach(u -> {
                sb.append(",");
                sb.append(u);
            });
        }
        sb.append("]");
        sb.append(",template_id=[" + template_id + "]");
        sb.append(",url=[" + url + "]");
        sb.append(",data=[");
        if (data == null || data.isEmpty()) {
            sb.append("null");
        } else {
            Set<Map.Entry<String, MessageDataValueItem>> entries = data.entrySet();
            entries.stream().forEach(entry -> {
                sb.append(",");
                sb.append(entry.getValue().getValue());
            });
        }
        sb.append("]");
        return sb.toString();
    }
}
