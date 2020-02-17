package com.test;

import com.demo.EmpBusinessLogic;
import com.demo.EmployeeDetails;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author evi1
 * @Create 2020/2/17 21:47
 */

public class TestEmployeeDetails {
    EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
    EmployeeDetails employee = new EmployeeDetails();

    @Test()
    public void testCalculateAppraisal() {
        employee.setName("Tom");
        employee.setAge(25);
        employee.setMonthlySalary(8000);
        double appraisal = empBusinessLogic.calculateAppraisal(employee);
        Assert.assertEquals(500, appraisal, 0.0, "500");
    }

    /**
     * Test to check yearly salary
     */
    @Test()
    public void testCalculateYearlySalary() {
        employee.setName("Tom");
        employee.setAge(25);
        employee.setMonthlySalary(8000);
        double salary = empBusinessLogic.calculateYearlySalary(employee);
        Assert.assertEquals(96000, salary, 0.0, "80000");
    }
}
