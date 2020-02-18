package com.test;

import com.demo.MessageUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author evi1
 * @Create 2020/2/18 12:47
 */

public class IgnoreTest {
    String message = "Rose";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(enabled = false)
    public void testPrintMessage() {
        System.out.println("inside testPrintMessage");
        Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test
    public void testSalutationMessage() {
        System.out.println("inside testSalutationMessage");
        message = "Hi!" + message;
        Assert.assertEquals(message, messageUtil.salutationMessage());
    }
}
