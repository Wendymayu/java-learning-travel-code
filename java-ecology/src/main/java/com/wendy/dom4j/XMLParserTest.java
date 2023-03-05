package com.wendy.dom4j;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/2 21:56
 * @Version 1.0
 */
public class XMLParserTest {
    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();
        List<Dependency> dependencyList = xmlParser.parseXML();
        for(Dependency dependency:dependencyList){
            System.out.println(dependency);
        }
    }
}
