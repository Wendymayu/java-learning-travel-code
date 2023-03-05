package com.wendy.leetcode.orderly.problem20_29;

import leetcode.shuaTi.wendyHot100.Recursive.ListNode;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/9/14 21:53
 * @Version 1.0
 */
public class Solution23 {
    // 优先队列合并
/*    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));

        // 合并链表元素到队列
        for(ListNode node:lists){
            while (node != null){
                queue.offer(node.val);
                node = node.next;
            }
        }
        // 把队列中元素添加到了新的链表
        ListNode ans = null;
        while (!queue.isEmpty()){
            ListNode curr = new ListNode(queue.poll()); // 每次拿出最大元素，并删除
            curr.next = ans;
            ans = curr;
        }
        return ans;
    }*/


    /**
     * 归并法
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}
