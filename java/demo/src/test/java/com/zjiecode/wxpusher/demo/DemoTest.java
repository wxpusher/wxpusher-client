package com.zjiecode.wxpusher.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 说明：测试代码
 * 作者：zjiecode
 * 时间：2019-10-05
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavaWebApplication.class)
public class DemoTest {
    @Test
    public void test() {
        System.out.println("test");
    }

}
