package com.wendy.jackson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/1 23:23
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Website {
    private String id;

    private String zhName;

    private String enName;

    private boolean otherService;

    private String url;
}
