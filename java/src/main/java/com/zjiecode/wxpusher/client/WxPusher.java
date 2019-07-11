package com.zjiecode.wxpusher.client;

import com.alibaba.fastjson.JSONObject;
import com.zjiecode.wxpusher.client.model.Message;
import com.zjiecode.wxpusher.client.model.MessageDataValueItem;
import com.zjiecode.wxpusher.client.model.Result;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：WxPusher的客户端
 * 作者：zjiecode
 * 时间：2019-05-03
 */
public class WxPusher {
    private static final String BASE_URL = "http://wxmsg.dingliqc.com/send/";


    /**
     * 发送消息
     *
     * @param msg    消息内容
     * @param userId 接收者id
     * @return 返回发送结果
     */
    public static Result send(String msg, String userId) {
        ArrayList<String> userIds = new ArrayList<>();
        userIds.add(userId);
        return send(msg, userIds);
    }

    /**
     * 发送消息
     *
     * @param msg     消息内容
     * @param userIds 接收者id,多个，是一个数组
     * @return 返回发送结果
     */
    public static Result send(String msg, List<String> userIds) {
        return send("", msg, null, userIds);
    }

    /**
     * 发送消息
     *
     * @param title  消息标题
     * @param msg    消息内容
     * @param url    消息附带的url，微信收到消息 ，点击以后打开这个url
     * @param userId 接收者id
     * @return 返回发送结果
     */
    public static Result send(String title, String msg, String url, String userId) {
        ArrayList<String> ids = new ArrayList<>();
        ids.add(userId);
        return send(title, msg, url, ids);
    }

    /**
     * post 发送数据
     *
     * @param title 标题
     * @param msg   消息
     * @param url   链接
     * @param uid   接收用户id
     * @return 发送结果
     */
    public static Result post(String title, String msg, String url, String uid) {
        return post(title, msg, url, new ArrayList<String>() {{
            add(uid);
        }});
    }

    /**
     * post 发送数据
     *
     * @param title 标题
     * @param msg   消息
     * @param url   链接
     * @param uids  接收用户id,多个，是一个数组
     * @return 发送结果
     */
    public static Result post(String title, String msg, String url, List<String> uids) {
        Map<String, MessageDataValueItem> data = new HashMap<>();
        data.put("first", new MessageDataValueItem(title, "#333333"));
        data.put("remark", new MessageDataValueItem(msg, "#333333"));
        Message message = new Message();
        message.setTemplate_id("post");
        message.setData(data);
        message.setUrl(url);
        message.setUserIds(uids);
        return send(message);
    }

    /**
     * 最完整的发送消息，支持设置消息颜色等。
     *
     * @param message 需要发送的消息
     * @return 返回发送结果
     * @deprecated 因为公众号被投诉，因此下线指定模版的功能，建议使用post接口代替。后期post接口会无感迁移。
     */
    public static Result send(Message message) {
        String valid = message.valid();
        if (valid != null) {
            return new Result(400, valid);
        }
        String data = JSONObject.toJSONString(message);
        System.out.println("data:" + data);
        try {
            URL cUrl = new URL(BASE_URL);
            HttpURLConnection urlConnection = (HttpURLConnection) cUrl.openConnection();
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestMethod("POST");
            //设置请求属性
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Charset", "UTF-8");
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            OutputStream outputStream = urlConnection.getOutputStream();
            outputStream.write(data.getBytes());
            outputStream.flush();
            return dealConnect(urlConnection);
        } catch (MalformedURLException e) {
            return new Result(400, "http地址错误");
        } catch (IOException e) {
            return new Result(400, e.getMessage());
        }
    }

    /**
     * 发送一个简单的消息
     *
     * @param title   消息的标题
     * @param msg     消息内容
     * @param url     点击消息的连接，如果不传，默认会打开消息详情，可以复制。不想代连接，可以传：nourl
     * @param userIds 接收者的id,多个，是一个数组
     * @return 返回发送结果
     */
    public static Result send(String title, String msg, String url, List<String> userIds) {
        if (msg == null || msg.isEmpty()) {
            return new Result(400, "msg不能为空");
        }
        if (userIds == null || userIds.isEmpty()) {
            return new Result(400, "userIds不能为空");
        }
        if (url == null) {
            url = "";
        }
        try {
            String ids = String.join(",", userIds);
            String query = String.format("title=%s&msg=%s&url=%s&userIds=%s", URLEncoder.encode(title), URLEncoder.encode(msg), URLEncoder.encode(url),
                    URLEncoder.encode(ids));
            URL cUrl = new URL(BASE_URL + "?" + query);
            HttpURLConnection urlConnection = (HttpURLConnection) cUrl.openConnection();
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            return dealConnect(urlConnection);
        } catch (MalformedURLException e) {
            return new Result(400, "http地址错误");
        } catch (IOException e) {
            return new Result(400, e.getMessage());
        }
    }

    /**
     * 处理连接以后的状态信息
     *
     * @param urlConnection 打开的连接
     * @return 返回发送结果
     */
    private static Result dealConnect(HttpURLConnection urlConnection) {
        try {
            if (urlConnection.getResponseCode() != 200) {
                return new Result(urlConnection.getResponseCode(), "http请求错误");
            }
            InputStream inputStream = urlConnection.getInputStream();
            String res = inputStream2String(inputStream);
            if (res == null || res.isEmpty()) {
                return new Result(500, "服务器返回异常");
            }
            Result result = JSONObject.parseObject(res, Result.class);
            if (result == null) {
                return new Result(500, "服务器返回数据解析异常");
            }
            return result;
        } catch (MalformedURLException e) {
            return new Result(400, "http地址错误");
        } catch (IOException e) {
            return new Result(400, e.getMessage());
        }
    }

    /**
     * 从输入流中读取内容到字符串
     *
     * @param inputStream 输入路
     * @return 返回字符串
     */
    private static String inputStream2String(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len = 0;
        byte[] bytes = new byte[4096];
        try {
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            return new String(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
