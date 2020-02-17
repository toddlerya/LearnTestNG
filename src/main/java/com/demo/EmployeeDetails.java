package com.demo;

/**
 * @author evi1
 * @Create 2020/2/17 21:36
 */

/**
 * EmployeeDetails类用于以下用途:
 *  - 获取/设置员工姓名的值
 *  - 获取/设置员工月薪的值
 *  - 获取/设置员工年龄的值
 * @author evi1
 */
public class EmployeeDetails {
    /**
     * 定义员工信息私有变量
     */
    private String name;
    private double monthlySalary;
    private int age;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return te monthlySalary
     */
    public double getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * @param monthlySalary the monthlySalary to set
     */
    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
