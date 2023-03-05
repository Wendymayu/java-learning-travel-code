package com.wendy.basic.advanced_feature.clonePrac;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/26 22:36
 * @Version 1.0
 */
public class PersonTest {
    public static void main(String[] args) {

        ClonePerson clonePerson1 = new ClonePerson();
        clonePerson1.setName("mawendy");
        System.out.println(clonePerson1);
        Timestamp timestamp = new Timestamp(10);
        clonePerson1.setBirthday(timestamp);
        System.out.println(clonePerson1);
     //我们只想通过clonePerson的set和get方法来改变对象的值
        //但是如果在set方法中不传clone()的timestamp对象，那么改变timeStamp的值也会改变clonePerson
        //这显然不是我们想看到的
        timestamp.setTime(1000000000);
        //如果不采用浅clone，可以看到。时间戳变了，对象的值也会变
        System.out.println(clonePerson1.toString());

    }
}
