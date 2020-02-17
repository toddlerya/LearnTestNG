package com.demo;

/**
 * @Author evi1
 * @Create 2020/2/17 21:36
 */

/**
 * EmpBusinessLogic类用于计算:
 * - 员工的年薪
 * - 员工的评估金额
 * @author evi1
 */
public class EmpBusinessLogic {
    /**
     *  员工的评估金额阈值
     */
    final int THRESHOLD_VALUE = 10000;

    /**
     * Calculate the yearly salary of employee
     */
    public double calculateYearlySalary(EmployeeDetails employeeDetails) {
        double yearlySalary = 0;
        yearlySalary = employeeDetails.getMonthlySalary() * 12;
        return yearlySalary;
    }

    /**
     * Calculate the appraisal amount of employee
     */
    public double calculateAppraisal(EmployeeDetails employeeDetails) {
        double appraisal = 0;
        if (employeeDetails.getMonthlySalary() < THRESHOLD_VALUE) {
            appraisal = 500;
        } else {
            appraisal = 1000;
        }
        return appraisal;
    }
}
