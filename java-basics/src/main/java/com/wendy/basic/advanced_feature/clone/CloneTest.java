package com.wendy.basic.advanced_feature.clone;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/1/22 19:32
 * @Version 1.0
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        test_clone_primitive();

      //  test_clone_reference();
    }

    private static void test_clone_primitive() throws CloneNotSupportedException {
        Phone phone = new Phone("1351616", 1);
        Person person = new Person();
        person.setName("乔峰");
        person.setAge(30);
        person.setPhone(phone);

        Object personCopy = person.clone();
        System.out.println(person);
        System.out.println(personCopy);

        person.setName("段誉");
        person.setAge(20);

        System.out.println("修改后------------------------------------------");
        System.out.println(person);
        System.out.println(personCopy);
    }

    private static void test_clone_reference() throws CloneNotSupportedException {
        Phone phone = new Phone("1351616", 1);
        Person person = new Person();
        person.setName("乔峰");
        person.setAge(30);
        person.setPhone(phone);

        Object personCopy = person.clone();
        System.out.println(person);
        System.out.println(personCopy);


        person.setName("段誉");
        person.setAge(20);
        phone.setNumber("111111");

        System.out.println("修改后---------------------------------------------");
        System.out.println(person);
        System.out.println(personCopy);
    }
}
