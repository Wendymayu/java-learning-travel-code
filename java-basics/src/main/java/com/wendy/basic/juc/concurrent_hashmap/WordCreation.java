package com.wendy.basic.juc.concurrent_hashmap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/2/8 22:47
 * @Version 1.0
 */
public class WordCreation {
    private static final String FILE_PATH = "D:/filepath/juc/";

    private static final String ALPHA = "abcedfghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException {
        int length = ALPHA.length();
        int count = 200;
        List<String> list = new ArrayList<>(length * count);

        // 每个英文字母生成200个加入list
        for (int i = 0; i < length; i++) {
            char ch = ALPHA.charAt(i);
            for (int j = 0; j < count; j++) {
                list.add(String.valueOf(ch));
            }
        }
        // 将26*200个字母打乱顺序
        Collections.shuffle(list);

        // 每200个字母为一组，存入26个txt文件
        for (int i = 0; i < 26; i++) {
            String path = FILE_PATH + (i + 1) + ".txt";
            File file = new File(path);
            if (!file.isFile()) {
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            String collect = list.subList(i * count, (i + 1) * count).stream()
                    .collect(Collectors.joining("\n"));
            writer.write(collect);
            writer.close();
        }
    }
}
