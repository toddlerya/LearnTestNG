package com.practice;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author evi1
 * @date 2020/2/21 01:04
 * ===== 分析下功能点 ======
 * AnalysisScore类有以下方法：
 * 1. setStudentList()   加载学生信息到列表，等待使用，不允许有重复的学号
 * 2. getStudentList()   获取已经加载的学生信息数组
 * 3. clearStudentList() 清空加载的学生信息数组，等待加载新的数据
 * 4. scoreRank()        对学生成绩进行从高到低排序，成绩相同的按照学号从小到大排序
 * 5. calcAvgScore()     计算所有学生的成绩的平均值
 * <p>
 * ====== 测试用例编写思路 ======
 * 1. 在所有用例执行前创建一个AnalysisScore类的对象，后续反复使用
 * 2. 每个方法执行完成后清理测试数据
 */

public class TestAnalysisScore {

    AnalysisScore asObj = new AnalysisScore();

    @BeforeMethod
    public void clearStudentList() {
        // 每个测试运行后清理数组，避免数据干扰
        asObj.clearStudentList();
    }

    @Test(groups = {"funcTest", "allTest"})
    public void testSetAndGetStudentList() {
        /*
        测试载入学生数据以及读取学生数据是否成功
         */
        StudentDetails a = new StudentDetails("小王", 1, 93);
        StudentDetails b = new StudentDetails("小刘", 2, 90);
        asObj.setStudentList(a, b);
        Assert.assertEquals(asObj.getStudentList().length, 2, "获取学生信息个数错误");
        Assert.assertEquals(asObj.getStudentList()[0].getName(), "小王", "获取学生姓名错误");
        Assert.assertEquals(asObj.getStudentList()[1].getCode(), 2, "获取学生成绩错误");
        Assert.assertEquals(asObj.getStudentList()[1].getScore(), 90, "获取学生成绩错误");
    }


    @Test(groups = {"funcTest", "allTest"})
    public void testClearStudentList() {
        // 载入数据后，测试能否清空数据
        asObj.clearStudentList();
        Assert.assertNull(asObj.getStudentList(), "StudentList数组未清空");
    }

    @Test(groups = {"funcTest", "allTest"})
    public void testScoreRank() {
        StudentDetails a = new StudentDetails("小王", 1, 90);
        StudentDetails b = new StudentDetails("小刘", 2, 93);
        StudentDetails c = new StudentDetails("小毛", 3, 90);
        StudentDetails d = new StudentDetails("小田", 4, 7);
        asObj.setStudentList(a, b, c, d);
        // 进行排序
        asObj.scoreRank();
        // 构造期望结果
        StudentDetails[] exceptStudentList = {b, a, c, d};
        Assert.assertEquals(asObj.getStudentList(), exceptStudentList, "成绩排序错误");
    }

    /*
    测试计算平均分功能是否正确
     */
    @Test(groups = {"funcTest", "allTest"})
    public void testCalcAvgScore() {
        StudentDetails a = new StudentDetails("小王", 1, 90);
        StudentDetails b = new StudentDetails("小刘", 2, 93);
        StudentDetails c = new StudentDetails("小毛", 3, 90);
        StudentDetails d = new StudentDetails("小田", 4, 7);
        asObj.setStudentList(a, b, c, d);
        // 计算平均分
        double actualAvgValue = asObj.calcAvgScore();
        // （90 + 93 + 90 + 7) / 4 = 70 期望结果
        Assert.assertEquals(actualAvgValue, 70.000, "平均值计算错误");
    }

    /*
     测试是否会校验重复学号，能否正确抛出报错信息
     */
    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "有学生学号重复.*\\s*.*\\s*.*\\s*.*",
            groups = {"allTest", "abnormalTest"})
    public void testSetStudentListWithCheckDuplicateCode() {
        StudentDetails a = new StudentDetails("小王", 1, 93);
        StudentDetails b = new StudentDetails("小刘", 1, 90);
        asObj.setStudentList(a, b);
    }

    /*
    测试是否会校验错误的学号，是否能正确抛出报错信息
     */
    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "有学生学号为小于零.*",
            groups = {"allTest", "abnormalTest"})
    public void testSetStudentListWithIllegalCode() {
        StudentDetails a = new StudentDetails("飒飒", -1, 33);
        asObj.setStudentList(a);
    }

    /*
    测试是否会校验错误的成绩，是否能正确抛出报错信息
     */
    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "有学生成绩为小于零.*",
            groups = {"allTest", "abnormalTest"})
    public void testSetStudentListWithIllegalScore() {
        StudentDetails a = new StudentDetails("飒飒", 3, -321);
        asObj.setStudentList(a);
    }
}