package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author evi1
 * @date 2020/2/21 01:04
 */

public class AnalysisScoreTest {
    /**
     * 初始化测试数据
     */
    public void initData() {
        // 创建若干个学生信息, 并初始化信息
        StudentDetails a = new StudentDetails("小王", 1, 93);
        StudentDetails b = new StudentDetails("小刘", 2, 90);
        StudentDetails c = new StudentDetails("小周", 3, 90);
        StudentDetails d = new StudentDetails("小张", 3, 100);
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