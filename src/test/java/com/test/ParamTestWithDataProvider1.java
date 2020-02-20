package com.test;

import com.demo.PrimeNumberChecker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author evi1
 * @Create 2020/2/18 21:41
 */

public class ParamTestWithDataProvider1 {
    private PrimeNumberChecker primeNumberChecker;

    @BeforeMethod
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
    }

    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() {
        return new Object[][]{{2, true}, {6, true}, {19, true}, {22, true}, {23, true}};
    }

    /**
     * This test will run 4 times since we have 5 parameters defined
     */
    @Test(dataProvider = "test1")
    public void testPrimeNumberChecker(Integer inputNumber, Boolean exceptedResult) {
        System.out.println(inputNumber + " " + exceptedResult);
        Assert.assertEquals(primeNumberChecker.validate(inputNumber), exceptedResult);
    }
}
