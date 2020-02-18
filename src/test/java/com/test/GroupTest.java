package com.test;

import com.demo.MessageUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author evi1
 * @Create 2020/2/18 12:58
 * 将测试方法分为两类：
 * - Check-in tests (checkintest) 应在提交新代码之前运行这些测试。它们通常应该很快并确保没有基本功能被破坏：
 * - Functional tests (functest) 这些测试应该涵盖软件的所有功能，并且尽量要频繁运行，高频策略。
 */

public class GroupTest {
    String message = "Lion";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(groups = {"functest", "checkintest"})
    public void testPrintMessage() {
        System.out.println("inside testPrintMessage()");
        message = "Lion";
        Assert.assertEquals(messageUtil.printMessage(), message);
    }

    @Test(groups = {"checkintest"})
    public void testSalutationMessage() {
        System.out.println("in testSalutationMessage()");
        message = "Hi!" + message;
        Assert.assertEquals(messageUtil.salutationMessage(), message);
    }

    @Test(groups = {"functest"})
    public void testExitMessage() {
        System.out.println("inside testExitMessage()");
        message = "Bye!" + message;
        Assert.assertEquals(messageUtil.exitMessage(), message);
    }
}
