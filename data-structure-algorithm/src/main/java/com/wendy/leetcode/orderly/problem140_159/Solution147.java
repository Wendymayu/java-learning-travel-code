package com.wendy.leetcode.orderly.problem140_159;

/**
 * @ClassName Solution147
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/17 11:46
 * @Version 1.0
 */
public class Solution147 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode newHead = insertionSortList3(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }


    static public ListNode insertionSortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = new ListNode(head.val);
        head = head.next;
        ListNode index = newHead;
        while (head != null) {
            while (index.next != null && index.next.val < head.val) {
                index = index.next;
            }
            ListNode temp = index.next;
            index.next = new ListNode(head.val);
            index.next.next = temp;
            head = head.next;
            index = newHead;
        }

        return newHead.next;
    }

    //方法2的优化
    static public ListNode insertionSortList3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode index = newHead;
            while (index.next != null && index.next.val < head.val) {
                index = index.next;
            }
            ListNode temp = new ListNode(head.val);
            temp.next = index.next;
            index.next = temp;
            head = head.next;
        }
        return newHead.next;
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
