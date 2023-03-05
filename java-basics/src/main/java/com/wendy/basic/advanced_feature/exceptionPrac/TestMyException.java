/*
package com.wendy.basic.advanced_feature.exceptionPrac;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exception")
public class TestMyException {
    public static void main(String[] args) {
        People p = new People();
        try {
            p.setSex("Male");
        } catch (MyException e) {
            e.printStackTrace();//输出异常信息
        }
    }

    @GetMapping("update")
    public String updateSex() throws MyException {
        People p = new People();
        p.setSex("Male");
        return "success";
    }
}

class People {
    private String sex;

    void setSex(String sex) throws MyException {
        if ("男".equals(sex) || "女".equals(sex)) {
            this.sex = sex;
        } else {
            throw new MyException("性别必须是男或者女");
        }
    }
}
*/
