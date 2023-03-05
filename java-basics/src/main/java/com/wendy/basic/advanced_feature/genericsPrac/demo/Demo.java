package com.wendy.basic.advanced_feature.genericsPrac.demo;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/3/5 13:32
 * @Version 1.0
 */
public class Demo {
    public <T> T get(T t){
        return t;
    }

    public <K> int getElment(List<K> list){
        return 0;
    }

    public int getElment2(List<?> list){
        return 0;
    }

}
