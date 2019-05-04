package com.zjiecode.wxpusher.client.model;

/**
 * 说明：
 * 作者：zjiecode
 * 时间：2019-05-03
 */
public class MessageDataValueItem {
    private String value;
    private String color;

    public MessageDataValueItem() {
    }

    public MessageDataValueItem(String value) {
        this.value = value;
        this.color = "#000000";
    }

    public MessageDataValueItem(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
