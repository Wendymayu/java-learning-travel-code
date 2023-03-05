package com.wendy.junit;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/20 23:53
 * @Version 1.0
 */
public class StatisticsUtils {
    public int getMax(int[] nums) {
        return Arrays.stream(nums).max().getAsInt();
    }
}
