package com.wendy.leetcode.orderly.problem501_700;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/3 14:21
 * @Version 1.0
 */
public class Solution622 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        ;// 返回 3
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());


//        MyCircularQueue circularQueue = new MyCircularQueue(6);
//        System.out.println(circularQueue.enQueue(6));
//        System.out.println(circularQueue.Rear());
//        System.out.println(circularQueue.Rear());

    }
}

class MyCircularQueue {
    private int[] queue;

    private int head;

    private int tail;

    private int length;

    private int size;

    public MyCircularQueue(int k) {
        head = 0;
        tail = -1;
        length = k;
        size = 0;
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % length;
        queue[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % length;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[tail];
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (size == length) {
            return true;
        }
        return false;
    }
}