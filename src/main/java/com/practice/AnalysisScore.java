package com.practice;

import java.text.DecimalFormat;

/**
 * @author evi1
 * @date 2020/2/20 23:08
 * 统计分析学生的成绩
 */

public class AnalysisScore {
    private StudentDetails[] studentList;

    public void setStudentList(StudentDetails... studentList) throws IllegalArgumentException {
        if (studentList.length == 0) {
            throw new IllegalArgumentException("请传入至少一个学生的详细信息!");
        }
        // 校验学号是否有重复
        for (int i = 0; i < studentList.length; i++) {
            for (int j = 0; j < studentList.length - 1 - i; j++) {
                if (studentList[j].getCode() == studentList[j + 1].getCode()) {
                    String msg = String.format("有学生学号重复，请检查：\nA>>> 姓名: %s, 学号: %d \nB>>> 姓名: %s, 学号: %d",
                            studentList[j].getName(), studentList[j].getCode(),
                            studentList[j + 1].getName(), studentList[j + 1].getCode());
                    throw new IllegalArgumentException(msg);
                }
            }
        }
        this.studentList = studentList;
    }

    /**
     * 获取已经加载的学生信息列表
     *
     * @return studentList
     */
    public StudentDetails[] getStudentList() {
        return studentList;
    }

    /**
     * 清空加载的学生信息列表，通常用语重新加载数据
     */
    public void clearStudentList() {
        this.studentList = null;
    }

    /**
     * 对学生的成绩按照从高到低进行排名，成绩相同的按照学号排序
     * 使用冒泡排序法
     *
     * @return studentList 排序后的学生详细信息对象列表
     */
    public StudentDetails[] scoreRank() {
        for (int i = 0; i < studentList.length; i++) {
            for (int j = 0; j < studentList.length - 1 - i; j++) {
                // 根据成绩从大到小排序
                if (studentList[j].getScore() < studentList[j + 1].getScore()) {
                    StudentDetails temp = studentList[j];
                    studentList[j] = studentList[j + 1];
                    studentList[j + 1] = temp;
                } else if (studentList[j + 1].getScore() == studentList[j].getScore()) {
                    // 若成绩相同，则按照学号排序，学号小的在前，学号大的在后。
                    if (studentList[j].getCode() > studentList[j + 1].getCode()) {
                        StudentDetails temp = studentList[j + 1];
                        studentList[j + 1] = studentList[j];
                        studentList[j] = temp;
                    }
                }
            }
        }
        return studentList;
    }

    /**
     * 求学生平均分
     * Tips: 这里有个问题，求平均分，必然会产生小数，在Java中，浮点数有float和double，用哪个呢？
     * float精度比double小，float类型精度较小在比较大小时有可能会出现误判
     * 对于这里求成绩的平均数，对精度没什么太多的要求，float和double都能胜任。
     * 记住一点：
     * 不能确认使用float和double的时候，请选择double，虽然有可能会有计算性能问题，但程序的第一要义是功能正确
     *
     * @return avgScore 平均分，保留3位小数
     */
    public double calcAvgScore() {
        // 获取所有学生的成绩，放入列表等待计算
        double avgScore;
        int sum = 0;
        for (StudentDetails stu : studentList) {
            sum += stu.getScore();
        }
        avgScore = (double) sum / studentList.length;
        // 保留3位小数
        DecimalFormat df = new DecimalFormat("#.###");
        avgScore = Double.parseDouble(df.format(avgScore));
        return avgScore;
    }
}
