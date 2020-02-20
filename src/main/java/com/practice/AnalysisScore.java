package com.practice;

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

    public StudentDetails[] getStudentList() {
        return studentList;
    }

    /**
     * 对学生的成绩按照从高到低进行排名，成绩相同的按照学号排序
     *
     * @return
     */
    public StudentDetails[] ScoreRank() {
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
}
