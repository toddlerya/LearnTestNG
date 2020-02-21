package com.practice;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author evi1
 * @date 2020/2/21 01:04
 * ===== 分析下功能点 ======
 * AnalysisScore类有以下方法：
 *  1. setStudentList()   加载学生信息到列表，等待使用
 *  2. getStudentList()   获取已经加载的学生信息数组
 *  3. clearStudentList() 清空加载的学生信息数组，等待加载新的数据
 *  4. scoreRank()        对学生成绩进行从高到低排序，成绩相同的按照学号从小到大排序
 *  5. calcAvgScore()     计算所有学生的成绩的平均值
 *
 *  ===== 测试用例编写思路 ======
 *  1. 在所有用例执行前创建一个AnalysisScore类的对象，后续反复使用
 *  2.
 */

public class AnalysisScoreTest {
    /**
     * 初始化测试数据
     */
    @BeforeClass
    public void initData() {
        // 创建若干个学生信息, 并初始化信息
        StudentDetails a = new StudentDetails("小王", 1, 93);
        StudentDetails b = new StudentDetails("小刘", 2, 90);
        StudentDetails c = new StudentDetails("小周", 3, 90);
        StudentDetails d = new StudentDetails("小张", 4, 100);
        AnalysisScore asObj = new AnalysisScore();
        asObj.setStudentList(a, b, c, d);
    }

    @Test
    public void testAnalysisScore() {
        initData();
    }

    @Test
    public void testScoreRank() {
    }
}