package com.wendy.basic.process_oriented.constants;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContantsDemoTest {
    @Test
    void test_getCircleArea_when_radius_2() {
        ContantsDemo contantsDemo = new ContantsDemo();
        double radius = 2.0;
        Assertions.assertEquals(12.56, contantsDemo.getCircleArea(radius));
    }
}