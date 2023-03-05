package com.wendy.java_collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

/**
 * @ClassName TestStack
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/17 19:56
 * @Version 1.0
 */
public class TestStack {
    public static void main(String[] args) {
      //  testStack();
        testDeque();
    }

    public static void testStack() {
        Stack<String> stack = new Stack<>();
        stack.add("dandan");
        stack.add("wendy");
        stack.push("cece");

        System.out.println("for循环遍历");
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
        System.out.println("增强for循环遍历");
        for (String s : stack) {
            System.out.println(s);
        }

        System.out.println("iterator迭代器遍历");
        Iterator<String> it = stack.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        stack.set(1, "baby");

        System.out.println("lambda遍历1");
        stack.forEach(items -> {
            System.out.println(items);
        });
        stack.remove(1);

        System.out.println("lambda遍历2");
        stack.forEach(System.out::println);

        System.out.println("弹出元素遍历");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void testDeque() {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("tom");
        stack.push("jerry");
        stack.push("spark");

        System.out.println(stack.peek());

        stack.pop();

        stack.isEmpty();
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
