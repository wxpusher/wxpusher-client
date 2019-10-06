package com.zjiecode.wxpusher.client;

import com.alibaba.fastjson.JSONObject;
import com.zjiecode.wxpusher.client.bean.Result;
import com.zjiecode.wxpusher.client.bean.ResultCode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

/**
 * 说明：网络请求工具
 * 作者：zjiecode
 * 时间：2019-09-05
 */
public final class HttpUtils {
    private static final String BASE_URL = "http://wxpusher.zjiecode.com";

    private HttpUtils() {
    }

    /**
     * 发送post请求
     *
     * @param data 发送的数据
     * @param path 请求后台的path
     * @return 发送的result结果
     */
    public static Result post(Object data, String path) {
        try {
            if (data == null) {
                return new Result(ResultCode.UNKNOWN_ERROR, "数据为空");
            }
            String dataStr = JSONObject.toJSONString(data);

            URL cUrl = new URL(buildUrl(path));
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
            outputStream.write(dataStr.getBytes());
            outputStream.flush();
            return dealConnect(urlConnection);
        } catch (MalformedURLException e) {
            return new Result(ResultCode.NETWORK_ERROR, e.getMessage());
        } catch (IOException e) {
            return new Result(ResultCode.NETWORK_ERROR, e.toString());
        } catch (Throwable e) {
            return new Result(ResultCode.UNKNOWN_ERROR, e.toString());
        }
    }

    public static Result get(String path) {
        return get(null, path);
    }

    /**
     * 发送get请求
     */
    public static Result get(Map<String, Object> data, String path) {
        try {
            String url = buildUrl(path);
            String query = parseMap2Query(data);
            if (!query.isEmpty()) {
                url = url + "?" + query;
            }
            URL cUrl = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) cUrl.openConnection();
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestMethod("GET");
            //设置请求属性
            urlConnection.setRequestProperty("Charset", "UTF-8");
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            return dealConnect(urlConnection);
        } catch (MalformedURLException e) {
            return new Result(ResultCode.NETWORK_ERROR, e.getMessage());
        } catch (IOException e) {
            return new Result(ResultCode.NETWORK_ERROR, e.toString());
        } catch (Throwable e) {
            return new Result(ResultCode.UNKNOWN_ERROR, e.toString());
        }
    }

    /**
     * 把map转成query查询字符串
     */
    private static String parseMap2Query(Map<String, Object> data) {
        if (data == null || data.size() <= 0) {
            return "";
        }
        Set<Map.Entry<String, Object>> entries = data.entrySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : entries) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return stringBuilder.toString();
    }

    /**
     *
     */
    private static String buildUrl(String path) {
        String url = BASE_URL;
        if (path != null && path.length() > 0) {
            if (path.startsWith("/")) {
                url = BASE_URL + path;
            } else {
                url = BASE_URL + "/" + path;
            }
        }
        return url;
    }

    /**
     * 处理连接以后的状态信息
     *
     * @param urlConnection 打开的连接
     * @return 返回发送结果
     */
    private static Result dealConnect(HttpURLConnection urlConnection) {
        try {
            int responseCode = urlConnection.getResponseCode();
            if (responseCode != 200) {
                return new Result(urlConnection.getResponseCode(), "http请求错误:" + responseCode);
            }
            InputStream inputStream = urlConnection.getInputStream();
            String res = inputStream2String(inputStream);
            if (res == null || res.isEmpty()) {
                return new Result(ResultCode.INTERNAL_SERVER_ERROR, "服务器返回异常");
            }
            Result result = JSONObject.parseObject(res, Result.class);
            if (result == null) {
                return new Result(ResultCode.DATA_ERROR, "服务器返回数据解析异常");
            }
            return result;
        } catch (MalformedURLException e) {
            return new Result(ResultCode.NETWORK_ERROR, e.getMessage());
        } catch (IOException e) {
            return new Result(ResultCode.NETWORK_ERROR, e.getMessage());
        } catch (Throwable e) {
            return new Result(ResultCode.UNKNOWN_ERROR, e.getMessage());
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
