package com.wendy.leetcode.orderly.problem400_450;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution401Test {

    @Test
    public void readBinaryWatch() {
        Solution401 solution = new Solution401();
        List<String> list = solution.readBinaryWatch(1);
        List<String> anser = new ArrayList<>(Arrays.asList("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00"));
        Collections.sort(list);
        list.toArray();
        Collections.sort(anser);
        Assertions.assertArrayEquals(list.toArray(), anser.toArray());
    }
}