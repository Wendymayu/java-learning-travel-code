package com.wendy.leetcode.orderly.problem140_159;

import java.util.*;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/9 22:01
 * @Version 1.0
 */
public class Solution146 {
    public static void main(String[] args) {
        // 测试1
/*        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4*/

       // 测试2
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache.get(2));
        lRUCache.put(2, 6);
        System.out.println(lRUCache.get(1));
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));

    }
}


/**
 * 我的解法超时
 */
class LRUCache {
    private Deque<List<Integer>> queue;

    private Map<Integer, Integer> map;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public int get(int key) {
        int result = -1;
        if(map.containsKey(key)){
            result = map.get(key);
        }else {

        }
        map.containsKey(key);
        Integer value = map.get(10);
        List<Integer> list = chechAndGet(key);
        if (list != null) {
            result = list.get(1);
            queue.remove(list);
            queue.addFirst(list);
        }
        return result;
    }

    public void put(int key, int value) {
        List<Integer> list = chechAndGet(key);
        if (list != null) {
            queue.remove(list);
            queue.addFirst(Arrays.asList(key, value));
        } else {
            if (queue.size() >= capacity) {
                queue.removeLast();
            }
            queue.addFirst(Arrays.asList(key, value));
        }
    }

    private List<Integer> chechAndGet(int key) {
        List<Integer> result = null;
        for (List<Integer> list : queue) {
            if (list.get(0) == key) {
                result = list;
                break;
            }
        }
        return result;
    }
}

// 官方取巧解答
class LRUCache2 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache2(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}