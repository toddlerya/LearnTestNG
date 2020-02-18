package com.test;

import com.demo.MessageUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author evi1
 * @Create 2020/2/18 14:58
 * 预期异常测试
 */

public class ExpectedExceptionTest {
    String message = "John";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(expectedExceptions = ArithmeticException.class)
    public void testPrintCalculateMessage() {
        System.out.println("inside testPrintCalculateMessage()");
        messageUtil.printCalculateMessage();
    }

    @Test
    public void testExitMessage() {
        System.out.println("inside testExitMessage()");
        message = "Bye!" + message;
        Assert.assertEquals(messageUtil.exitMessage(), message);
    }
}
