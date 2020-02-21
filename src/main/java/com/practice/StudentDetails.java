package com.practice;

/**
 * @author evi1
 * @date 2020/2/20 22:50
 * 定义学生的基础信息和相关成绩信息
 */

public class StudentDetails {
    private String name;
    private int code;
    private int score;

    public StudentDetails() {

    }

    /**
     * 有参数的构造方法，快速完成对象创建并初始化
     *
     * @param name  学生姓名
     * @param code  学号
     * @param score 成绩
     */
    public StudentDetails(String name, int code, int score) {
        this.setName(name);
        this.setCode(code);
        this.setScore(score);
    }

    /**
     * @param name 设置姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return name 获取姓名
     */
    public String getName() {
        return name;
    }

    /**
     * @param code 设置学号
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return code 获取学号
     */
    public int getCode() {
        return code;
    }

    /**
     * @param score 设置成绩
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return mathScore 获取成绩
     */
    public int getScore() {
        return score;
    }
}
