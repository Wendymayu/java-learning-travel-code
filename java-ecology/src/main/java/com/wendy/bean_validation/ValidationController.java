package com.wendy.bean_validation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/3 22:31
 * @Version 1.0
 */
@RestController
@RequestMapping("/validation")
public class ValidationController {
/*    @PostMapping("/insert")
    public Object insert(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            return errors.getAllErrors();
        }
        return null;
    }*/

    @PostMapping("/insert")
    public Object insert(@Valid @RequestBody User user) {
        return "成功";
    }
}
