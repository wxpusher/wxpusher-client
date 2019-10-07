package com.zjiecode.wxpusher.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

/**
 * 说明：
 * 作者：zjiecode
 * 时间：2019-10-07
 */
@Component
@Slf4j
public class CommonService {
    @Value("${spring.profiles.active}")
    String activeEnv;

    @PostConstruct
    private void init() {
        log.info("运行环境：" + activeEnv);
    }
}
