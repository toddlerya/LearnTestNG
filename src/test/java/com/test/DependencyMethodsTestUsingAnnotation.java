package com.test;

import com.demo.MessageUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.PublicKey;

/**
 * @Author evi1
 * @Create 2020/2/18 15:09
 */

public class DependencyMethodsTestUsingAnnotation {
    String message = "Thor";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        System.out.println("inside testPrintMessage()");
        Assert.assertEquals(messageUtil.printMessage(), message);
    }

    @Test(dependsOnMethods = {"initEnvironmentTest"})
    public void testSalutationMessage() {
        System.out.println("inside testSalutationMessage()");
        message = "Hi!" + message;
        Assert.assertEquals(messageUtil.salutationMessage(), message);
    }

    @Test
    public void initEnvironmentTest() {
        System.out.println("This is EnvironmentTest");
    }
}
