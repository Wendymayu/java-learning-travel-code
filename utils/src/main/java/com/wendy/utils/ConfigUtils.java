package com.wendy.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * @Description 当我想使用JDBC操作数据库，我发现创建mysql连接需要读配置化文件属性
 * @Author wendyma
 * @Date 2023/3/5 20:30
 * @Version 1.0
 */
@Slf4j
public class ConfigUtils {
    private static final Properties properties = new Properties();

    private static final String application_properties_path = "src/main/resources/application.properties";

    /**
     * 类加载时执行代码。需要类加载时就读入配置，方便其他服务获取配置
     */
    static {
        init();
    }

    private static void init() {
        File file = new File(application_properties_path);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            log.error("there is no properties file, {}", e.getMessage());
        } catch (IOException e) {
            log.error("load file fail");
        }
    }

    public static String getValue(String key, String defaultValue) {
        Object value = properties.get(key);
        if (Objects.nonNull(value)) {
            return (String) value;
        }
        return defaultValue;
    }
}
