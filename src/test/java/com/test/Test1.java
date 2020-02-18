package com.test;

import com.demo.MessageUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author evi1
 * @Create 2020/2/18 12:35
 */

public class Test1 {
    String message = "Jack";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        System.out.println("inside testPrintMessage()");
        Assert.assertEquals(message, messageUtil.printMessage());
    }
}
