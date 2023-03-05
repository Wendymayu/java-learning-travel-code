package com.wendy.sword_for_offer;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/12 10:29
 * @Version 1.0
 */
public class Solution5 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("hello world"));
        System.out.println(replaceSpace2("hello world hhh"));
    }

    static public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    static public String replaceSpace2(String s) {
        int index;
        while ((index = s.indexOf(" ")) != -1) {
            s = s.substring(0, index) + "%20" + s.substring(index + 1);
        }
        return s;
    }
}
