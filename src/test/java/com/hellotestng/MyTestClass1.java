package com.hellotestng;

import org.testng.annotations.Test;

/**
 * @author evi1
 * @date 2020/2/22 00:17
 */

public class MyTestClass1 extends ShowTestNGAnnotation {
    @Test
    public void myTestMethod1() {
        System.out.println("myTestMethod1");
    }


    @Test
    public void myTestMethod2() {
        System.out.println("myTestMethod2");

    }
}
