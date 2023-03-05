package com.wendy.bean_validation;

import com.wendy.bean_validation.myValidation.MyNotNull;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/3 22:34
 * @Version 1.0
 */
@Data
public class User {
    @MyNotNull(message = "字符串对象不能为空")
    private String userName;

    @NotNull
    @Size(min = 3, max = 8, message = "昵称长度在3-8之间")
    private String nickName;

    @Max(value = 20, message = "最大长度为20")
    private String address;

    @DecimalMin(value = "18", message = "年龄最小为18")
    @DecimalMax(value = "60", message = "年龄不能超过60")
    private Integer age;

    @Email(regexp = "[1-9]*", message = "必须为邮箱格式")
    private String email;

    @Pattern(regexp = "[1-9]*", message = "号码必须为数字")
    private String phone;
}
