package com.wendy.basic.advanced_feature.clone;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/1/22 19:28
 * @Version 1.0
 */
public class Person implements Cloneable{
    private String name;

    private int age;

    private Phone phone;

    public Person(){

    }

    public Person(String name, int age) {
         int person = Person.this.age;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }
}

class Phone {
    private String number;

    private int type;

    public Phone(String number, int type) {
        this.number = number;
        this.type = type;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", type=" + type +
                '}';
    }
}
