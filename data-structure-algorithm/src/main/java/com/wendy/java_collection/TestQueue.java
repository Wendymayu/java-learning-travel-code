package com.wendy.java_collection;

import java.util.*;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/8/17 22:47
 * @Version 1.0
 */
public class TestQueue {
    public static void main(String[] args) {
        testQueue();
    }

    static void testQueue() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("dandan");
        queue.offer("wendy");
        queue.offer("baby");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        // queue.poll();
        queue.remove();
        System.out.println(queue.peek());

        String peek = queue.peek();
        //   String element = queue.element();
    }

    public static void testPriorityQueue() {
        Comparator<String> cmp = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(cmp);
        PriorityQueue<String> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());

        // 增
        priorityQueue.offer("dandan");
        priorityQueue.offer("wendy");
        priorityQueue.offer("baby");

        // 删
        priorityQueue.poll();
        priorityQueue.remove();

        // 查看
        String peek = priorityQueue.peek();
        String element = priorityQueue.element();

        // 遍历
        while (priorityQueue.size() > 0) {
            System.out.println(priorityQueue.remove() + " ");
        }
    }

    static private void testDeque() {
        Deque<String> deque = new LinkedList<>();
        Deque<String> deque2 = new ArrayDeque<>();
    }

}
