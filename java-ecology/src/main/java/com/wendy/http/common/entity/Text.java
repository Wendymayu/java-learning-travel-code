package com.wendy.http.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/22 22:34
 * @Version 1.0
 */
@Data
public class Text {
    @JsonProperty("src")
    private String src;

    @JsonProperty("dst")
    private String dst;
}
