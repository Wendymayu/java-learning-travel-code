package com.wendy.leetcode.orderly.problem140_159;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/9/14 21:26
 * @Version 1.0
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
