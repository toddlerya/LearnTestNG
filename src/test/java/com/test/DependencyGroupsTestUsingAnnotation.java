package com.test;

import com.demo.MessageUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author evi1
 * @Create 2020/2/18 15:09
 */

public class DependencyGroupsTestUsingAnnotation {
    String message = "Thor";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(groups = {"init"})
    public void testPrintMessage() {
        System.out.println("inside DependencyGroups testPrintMessage()");
        Assert.assertEquals(messageUtil.printMessage(), message);
    }

    @Test(dependsOnGroups = {"init.*"})
    public void testSalutationMessage() {
        System.out.println("inside DependencyGroups testSalutationMessage()");
        message = "Hi!" + message;
        Assert.assertEquals(messageUtil.salutationMessage(), message);
    }

    @Test(groups = {"init"})
    public void initEnvironmentTest() {
        System.out.println("This is DependencyGroups EnvironmentTest");
    }
}
