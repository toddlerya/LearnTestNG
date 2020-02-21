package com.practice;

/**
 * @author evi1
 * @date 2020/2/21 22:27
 * 展示下成绩分析工具的使用方式
 */

public class Run {
    public static void main(String[] args) {
        // 创建4名同学，并对其赋值进行初始化
        StudentDetails a = new StudentDetails("小王", 1, 91);
        StudentDetails b = new StudentDetails("小刘", 2, 90);
        StudentDetails c = new StudentDetails("小周", 3, 90);
        StudentDetails d = new StudentDetails("小张", 4, 100);
        // 创建分数分析工具对象
        AnalysisScore asObj = new AnalysisScore();
        // 加载4名同学的信息
        asObj.setStudentList(a, b, c, d);

        /*
        输出展示下原始的同学成绩信息，将按照数据加载的顺序输出。
        输出结果：
        姓名：小王，学号：1，成绩：93
        姓名：小刘，学号：2，成绩：90
        姓名：小周，学号：3，成绩：90
        姓名：小张，学号：4，成绩：100
        */
        System.out.println("======原始数据学生名单=======");
        for (StudentDetails stu : asObj.getStudentList()) {
            System.out.printf("姓名：%s，学号：%d，成绩：%d\n", stu.getName(), stu.getCode(), stu.getScore());
        }

        /*
        使用排序方法，对学生成绩按照从高到低排序，成绩相同则按照学号从小到大排序。
        输出结果：
        姓名：小张，学号：4，成绩：100
        姓名：小王，学号：1，成绩：93
        姓名：小刘，学号：2，成绩：90
        姓名：小周，学号：3，成绩：90
         */
        StudentDetails[] sortedStudentScoreList = asObj.scoreRank();
        System.out.println("\n=====排序后的学生名单========");
        for (StudentDetails stu : sortedStudentScoreList) {
            System.out.printf("姓名：%s，学号：%d，成绩：%d\n", stu.getName(), stu.getCode(), stu.getScore());
        }

        /*
         * 求所有学生成绩平均值，保留三维小数
         */
        System.out.println("\n所有学生成绩的平均值为： " + asObj.calcAvgScore());
    }
}
