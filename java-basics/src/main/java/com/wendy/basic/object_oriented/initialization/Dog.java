package com.wendy.basic.object_oriented.initialization;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/12/16 7:58
 * @Version 1.0
 */
public class Dog extends Animal{
    static int age = getAge();

    private String name = getDogName();

    {
        System.out.println("子类Dog的一般代码块");
    }

    static {
        System.out.println("子类Dog的静态代码块");
    }
    public Dog(){
        this.name = "Dog";
        System.out.println("子类Dog的构造方法");
    }

    public static int getAge(){
        System.out.println("子类Dog的静态成员变量");
        return 2;
    }

    public String getDogName(){
        System.out.println("子类Dog的普通成员变量");
        return "dog";
    }

    public static void printAge(){
        System.out.println("子类Dog的静态方法");
    }

    public String printName(){
        System.out.println("子类Dog的普通方法");
        return name;
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        System.out.println("静态方法是否具有多态性？-------------------");
        dog.printAge();
    }
}

class Animal{
    static int age = getAge();

    private String name = getName();

    {
        System.out.println("基类Animal的一般代码块");
    }

    static {
        System.out.println("基类Animal的静态代码块");
    }
    public Animal(){
        this.name = "Animal";
        System.out.println("基类Animal的构造方法");
    }

    public static int getAge(){
        System.out.println("基类Animal的静态成员变量");
        return 2;
    }

    public String getName(){
        System.out.println("基类Animal的普通成员变量");
        return "dog";
    }

    public static void printAge(){
        System.out.println("基类Animal的静态方法");
    }

    public String printName(){
        System.out.println("基类Animal的普通方法");
        return name;
    }
}