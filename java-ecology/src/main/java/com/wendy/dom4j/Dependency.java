package com.wendy.dom4j;

import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/2 21:36
 * @Version 1.0
 */
@Data
public class Dependency {
    private String groupId;

    private String artifactId;

    private String version;
}
