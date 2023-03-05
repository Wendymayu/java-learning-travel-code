package com.wendy.utils;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/11 14:03
 * @Version 1.0
 */
public class ListUtils {
    public static <T> void printList(List<T> list) {
        for (T t : list) {
            System.out.print(t + " | ");
        }
        System.out.println("");
    }
}
