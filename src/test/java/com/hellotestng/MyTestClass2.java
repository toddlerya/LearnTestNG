package com.hellotestng;

import org.testng.annotations.Test;

/**
 * @author evi1
 * @date 2020/2/22 00:17
 */

public class MyTestClass2 extends ShowTestNGAnnotation {
    @Test
    public void myTestMethod3() {
        System.out.println("myTestMethod3");
    }


    @Test
    public void myTestMethod4() {
        System.out.println("myTestMethod4");
    }
}
