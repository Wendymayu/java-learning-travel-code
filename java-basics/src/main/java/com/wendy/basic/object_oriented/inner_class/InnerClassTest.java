package com.wendy.basic.object_oriented.inner_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/19 0:40
 * @Version 1.0
 */
public class InnerClassTest {
    public static void main(String[] args) {
        new Animal(){
            public void eat(){
                System.out.println("老虎吃肉");
            }
        }.eat();
        Collections.sort(new ArrayList<Integer>(), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }
}
class Animal{
    public void eat(){
        System.out.println("动物吃东西");
    }
}