package com.wendy.basic.common_library.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/25 8:18
 * @Version 1.0
 */
public class regularTest {
    public static void main(String[] args) {
        String content = "I am noob " + "from runoob.com.";

        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);

        testStart();
    }

    static public void testStart() {
        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("aaa2223bb");
        m.find();//匹配2223
        int a = m.start();//返回3
        int b = m.end();//返回7,返回的是2223后的索引号
        String s = m.group();//返回2223

        System.out.println(a);
        System.out.println(b);
        System.out.println(s);
    }
}
