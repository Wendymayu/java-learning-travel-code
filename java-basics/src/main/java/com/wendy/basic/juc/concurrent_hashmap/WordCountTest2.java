package com.wendy.basic.juc.concurrent_hashmap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/2/8 23:25
 * @Version 1.0
 */
public class WordCountTest2 {
    private static final String FILE_PATH = "D:/filepath/juc/";

    public static void main(String[] args) {
        demo(() -> new ConcurrentHashMap<String, LongAdder>(),
                (map, words) -> {
                    for (String word : words) {
                        // 注意不能使用 putIfAbsent，此方法返回的是上一次的 value，首次调用返回 null
                        map.computeIfAbsent(word, (key) -> new LongAdder()).increment();
                    }
                }
        );
    }

    private static <V> void demo(Supplier<Map<String, V>> supplier,
                                 BiConsumer<Map<String, V>, List<String>> consumer) {
        //获取Map集合
        Map<String, V> counterMap = supplier.get();

        // 创建Thread 线程的ArrayList列表
        List<Thread> ts = new ArrayList<>();

        // 启动26个线程，并发读取26个txt文件
        for (int i = 1; i <= 26; i++) {
            int idx = i;
            Thread thread = new Thread(() -> {
                // 读取完成一个txt文件返回200个单词
                List<String> words = readFromFile(idx);

                // 存入当前Map集合
                consumer.accept(counterMap, words);
            });
            ts.add(thread);
        }

        // 启动全部线程
        ts.forEach(t -> t.start());
        ts.forEach(t -> {
            try {
                // 调用线程等待26个线程执行结束
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 26个线程全部执行完成，输出map集合
        System.out.println(counterMap);
    }

    private static List<String> readFromFile(int i) {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH
                + i + ".txt")))) {
            while (true) {
                String word = in.readLine();
                if (word == null) {
                    break;
                }
                words.add(word);
            }
            return words;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
