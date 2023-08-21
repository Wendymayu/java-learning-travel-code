package com.wendy.leetcode.orderly.problem140_159;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/11 23:04
 * @Version 1.0
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            if (list.contains(currentNode)) {
                return currentNode;
            }
            list.add(currentNode);
            currentNode = currentNode.next;
        }
        return null;
    }
}
