package com.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author evi1
 * @Create 2020/2/18 16:40
 */

public class ParameterizedTest1 {
    @Test
    @Parameters("myName")
    public void parameterTest(String myName) {
        System.out.println("Parameterized value is : " + myName);
    }
}
