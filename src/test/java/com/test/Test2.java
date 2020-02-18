package com.test;

import com.demo.MessageUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author evi1
 * @Create 2020/2/18 12:35
 */

public class Test2 {
    String message = "Jack";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testSalutationMessage() {
        System.out.println("inside testSalutationMessage()");
        message = "Hi!" + "Jack";
        Assert.assertEquals(message, messageUtil.salutationMessage());
    }
}
