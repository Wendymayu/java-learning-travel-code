package com.wendy.basic.advanced_feature.genericsPrac;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GeneTest
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/11 19:43
 * @Version 1.0
 */
public class GeneTest {
    public static void main(String[] args) {
        Generate<Integer> integerGenerate = new Generate<>();
        Generate<String> stringGenerate = new Generate<>();
        Class gene1 = integerGenerate.getClass();
        Class gene2 = stringGenerate.getClass();
        System.out.println(gene1.equals(gene2));
    }
}

class Generate<T>{
    private T name;

    public Generate(){

    }

    //构造器参数由外部指定
    public Generate(T name) {
        this.name = name;
    }

    public T getName( ){   //泛型方法getName的返回值类型为T由外部指定
        return this.name;
    }

    public  <T> T method1(T t){
        List<Integer> list = new ArrayList<>();
        return t;
    }

    //泛型方法
    public  <K,P> P method2(K k,P p){
        List<Integer> list = new ArrayList<>();
        return p;
    }

    //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
    //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
    public <E> void show1(E t){
        System.out.println(t.toString());
    }

    //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
    public <T> void show2(T t){
        System.out.println(t.toString());
    }
}
