package com.wendy.basic.advanced_feature.genericsPrac;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/16 23:50
 * @Version 1.0
 */
public class PlateTest {
    public static void main(String[] args) {

        Plate<Apple> apples = new Plate<>();
        //Plate<Fruit> plate = new Plate<Apple>(); //类型转换失败

        Plate<? extends  Fruit> fruits1 = apples;
        //apples.add(new Apple());
        //fruits1.add(new Apple());  //fruits1中无法添加对象

        //List<? extends  Fruit> fruits2 = new ArrayList<? extends  Fruit>(); 没有类型，不能实例化
        Plate plate = new Plate();
        //plate.test1(fruits1);    //失败,因为call方法的实现方式，可能加入Banana到fruits1中，这是不行的

        Plate<? super Apple> list = new Plate<Apple>();
        Plate<? super Apple> list2 = new Plate<Fruit>();
       // Plate<? super Apple> list3 = new Plate<Banana>();
        list.setItem(new Apple());
        //list.setItem(new Banana());
        //list2.setItem(new Fruit());
        //list.setItem(new Fruit());

        //Apple apple = list.getItem();
        //Apple apple2 = list2.getItem();

        Object object = list.getItem();
        Apple apple3 = (Apple)object;

        Plate<? super Fruit> list4 = new Plate<Fruit>();
        list4.setItem(new Apple());
        list4.setItem(new Banana());
    }
}
