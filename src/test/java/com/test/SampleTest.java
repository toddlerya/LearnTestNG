package com.test;

import com.demo.MessageUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author evi1
 * @Create 2020/2/18 12:17
 */

public class SampleTest {
    String message = "Hello World";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        Assert.assertEquals(message, messageUtil.printMessage());
    }
}
