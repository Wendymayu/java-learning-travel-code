package com.wendy.leetcode.orderly.problem40_69;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/8/29 22:23
 * @Version 1.0
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead;
        ListNode tmp = head;
        int length = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            length++;
        }
        tmp.next = head; // 变成循环链表
        tmp = head;
        int move = length - k%length -1;
        while(move>0){
            tmp = tmp.next;
            move--;
        }
        newHead = tmp.next;
        tmp.next = null;
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
