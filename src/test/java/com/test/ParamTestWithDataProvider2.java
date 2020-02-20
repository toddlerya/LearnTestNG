package com.test;

import com.demo.Bean;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * @Author evi1
 * @Create 2020/2/18 22:12
 */

public class ParamTestWithDataProvider2 {
    @DataProvider(name = "test2")
    public static Object[][] primeNumbers() {
        return new Object[][]{{new Bean("Hi, I am the bean", 111)}};
    }

    @Test(dataProvider = "test2")
    public void testMethod(Bean myBean) {
        System.out.println(myBean.getVal() + " " + myBean.getI());
    }
}
