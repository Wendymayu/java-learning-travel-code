package com.wendy.leetcode.orderly.problem210_239;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/8/27 23:56
 * @Version 1.0
 */
public class Solution225 {

    private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public Solution225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        for(int i=0;i<size-1;i++){
            int tmp = queue.poll();
            queue.add(tmp);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        /*int size = queue.size();
        for(int i=0;i<size-1;i++){
            int tmp = queue.poll();
            queue.add(tmp);    //这样只能第一次看栈顶正确，下次看的就是栈底了
        }*/
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
