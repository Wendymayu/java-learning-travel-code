package com.wendy.basic.advanced_feature.genericsPrac;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/13 23:56
 * @Version 1.0
 */
class Fruit{
    public void call() {
        System.out.println("这是一个水果");
    }
}

class Banana extends Fruit{
    @Override
    public void call() {
        System.out.println("这是一个香蕉");

    }
}

class Apple extends Fruit{
    @Override
    public void call() {
        System.out.println("这是一个苹果");
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plate<T>{
   private T item;
}
