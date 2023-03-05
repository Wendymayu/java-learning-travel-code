package com.wendy.http.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/22 22:35
 * @Version 1.0
 */
@Data
public class TranslationResult {
    @JsonProperty(value = "from")
    private String from;

    @JsonProperty(value = "to")
    private String to;

    @JsonProperty(value = "trans_result")
    private List<Text> transResult;
}
