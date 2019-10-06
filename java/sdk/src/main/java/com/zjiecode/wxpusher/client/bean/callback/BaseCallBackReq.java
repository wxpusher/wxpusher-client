package com.zjiecode.wxpusher.client.bean.callback;

/**
 * 说明：wxpusher回调的数据结构
 * 作者：zjiecode
 * 时间：2019-10-05
 */
public class BaseCallBackReq {
    //二维码被扫描的时候
    public static final String ACTION_APP_SUBSCRIBE="app_subscribe";
    //回调的事件
    private String action;
    private Object data;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
