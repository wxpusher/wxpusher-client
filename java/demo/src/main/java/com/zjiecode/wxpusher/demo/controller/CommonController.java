package com.zjiecode.wxpusher.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：
 * 作者：zjiecode
 * 时间：2019-10-05
 */
@RestController
@RequestMapping("/demo")
public class CommonController {
    /**
     * 服务状态判断，返回OK表示服务状态OK
     */
    @GetMapping("/alive")
    public String alive() {
        return "OK";
    }

}
