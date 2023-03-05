package com.wendy.leetcode.orderly.problem1_9;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/9/12 8:49
 * @Version 1.0
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);

            // 到最上或者最下行，转向
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
