package com.wendy.junit;

import org.junit.jupiter.api.*;

public class MathUtilTest {
    @BeforeAll
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterAll
   public static void afterClass(){
        System.out.println("afterClass");
    }

    @BeforeEach
    void before(){
        System.out.println("before method");
    }

    @AfterEach
    void after(){
        System.out.println("after method");
    }


    @Test
    void test_sum_when_param_2_1() {
        MathUtil mathUtil = new MathUtil();
        int sum = mathUtil.sum(2, 1);
        Assertions.assertEquals(3, sum);
        System.out.println("test_sum_when_param_2_1");
    }

    @Test
    void test_multi_when_param_3_4() {
        MathUtil mathUtil = new MathUtil();
        int sum = mathUtil.multiply(3, 4);
        Assertions.assertEquals(12, sum);
        System.out.println("test_multi_when_param_3_4");
    }
}