package com.zjiecode.wxpusher.demo.controller;

import com.zjiecode.wxpusher.client.WxPusher;
import com.zjiecode.wxpusher.client.bean.CreateQrcodeReq;
import com.zjiecode.wxpusher.client.bean.CreateQrcodeResp;
import com.zjiecode.wxpusher.client.bean.Result;
import com.zjiecode.wxpusher.client.bean.ResultCode;
import com.zjiecode.wxpusher.demo.DataRepo;
import com.zjiecode.wxpusher.demo.result.BizException;
import com.zjiecode.wxpusher.demo.utils.RandomUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * 说明：演示发送消息
 * 作者：zjiecode
 * 时间：2019-10-05
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DisplayController {
    @Value("${wxpusher.biz.apptoken}")
    private String appToken;

    /**
     * 发送普通文本
     */
    @GetMapping("")
    public ModelAndView display() {
        //生成一个随机字符串来当作二维码标志，实际使用的时候，可以使用用户ID，避免重复。最大64位
        String qrcodeId = RandomUtil.getRandomStr(32);
        //创建一个参数二维码
        CreateQrcodeReq createQrcodeReq = new CreateQrcodeReq();
        createQrcodeReq.setAppToken(appToken);
        createQrcodeReq.setValidTime(3600);//二维码有效时间
        createQrcodeReq.setExtra(qrcodeId);
        Result<CreateQrcodeResp> tempQrcode = WxPusher.createAppTempQrcode(createQrcodeReq);
        if (!tempQrcode.isSuccess()) {
            throw new BizException(tempQrcode.getMsg());
        }
        Map<String, Object> data = new HashMap<>();
        data.put("qrcodeUrl", tempQrcode.getData().getUrl());
        data.put("qrcodeId", qrcodeId);
        return new ModelAndView("display", data);
    }

    @GetMapping("/getuid/{qrcodeId}")
    public Result getUidByQrcodeId(@PathVariable("qrcodeId") String qrcodeId) {
        if (StringUtils.isEmpty(qrcodeId)) {
            return new Result(ResultCode.BIZ_FAIL, "二维码错误");
        }
        String uid = DataRepo.get(qrcodeId);
        if (StringUtils.isEmpty(uid)) {
            return new Result(ResultCode.SUCCESS, "等待用户扫描");
        } else {
            Result result = new Result(ResultCode.SUCCESS, "处理成功");
            result.setData(uid);
            DataRepo.remove(qrcodeId);
            return result;
        }
    }


}
