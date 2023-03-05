package com.wendy.utils;

import com.wendy.pojo.ListNode;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/12 11:00
 * @Version 1.0
 */
public class ListNodeUtils {
    public static ListNode headNode(int[] array) {
        ListNode head = new ListNode(-1);
        ListNode yummyHead = head;
        for (int i : array) {
            ListNode node = new ListNode(i);
            yummyHead.next = node;
            yummyHead = yummyHead.next;
        }
        return head;
    }
}
