package com.wendy.basic.advanced_feature.clonePrac;

import lombok.*;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/26 22:33
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClonePerson {
    private String name;

    private Timestamp birthday;

    public Timestamp getBirthday() {
        if(birthday ==null){
            return null;
        }
        return (Timestamp)birthday.clone();
    }

    public void setBirthday(Timestamp birthday) {
        if(birthday!=null){
            this.birthday = (Timestamp)birthday.clone();
        }
    }
}
