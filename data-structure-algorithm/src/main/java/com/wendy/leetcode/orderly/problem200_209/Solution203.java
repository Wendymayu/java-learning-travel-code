package com.wendy.leetcode.orderly.problem200_209;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/19 23:46
 * @Version 1.0
 */
public class Solution203 {
    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);
        ListNode dummyHead =removeElements(head,7);
        while(dummyHead!=null){
            System.out.println(dummyHead.val);
            dummyHead = dummyHead.next;
        }
    }
   static public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode index = dummyHead;
        while (index!=null && index.next!=null){
            if(index.next.val==val){
                index.next = index.next.next;  //去掉一个节点的操作
                continue;
            }
            index = index.next;
        }
        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
