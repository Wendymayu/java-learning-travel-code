package com.wendy.sword_for_offer;

import com.wendy.leetcode.wendyHot100.Recursive.ListNode;
import com.wendy.utils.ArrayUtils;
import com.wendy.utils.ListNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/12 10:44
 * @Version 1.0
 */
public class Solution6 {
    public static void main(String[] args) {
        int[] array = {1, 3, 2};
        ListNode head = ListNodeUtils.headNode(array);
        int[] res = reversePrint(head.next);
        ArrayUtils.printElement(res);
    }

    static public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int length = list.size();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[length - i - 1] = list.get(i);
        }
        return res;
    }
}
