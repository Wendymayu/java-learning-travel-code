package com.wendy.java_collection;

import java.util.*;
import java.util.Map.Entry;

public class TestMap {
    public static void main(String[] args) {
        testHashMap();
        //testLinkedHashMap();
        //testTreeMap();

    }

    public static void testHashMap() {
        Map<String, Integer> map = new HashMap<>();
        String[] persons = {"丹丹", "马小迪", "李策", "丹丹"};

        for (String s : persons) {
            /*if(!map.containsKey(s)){
                map.put(s,1);
            }else{
                map.put(s,map.get(s)+1);
            }*/
            //map.put(s,map.getOrDefault(s,0)+1);

            map.put(s, !map.containsKey(s) ? 1 : map.get(s) + 1);
        }


        //map.putIfAbsent("丹丹",1);
        System.out.println("通过键集合keyset遍历");
        for (String s : map.keySet()) {
            System.out.println(s + ": " + map.get(s));
        }
        map.put("李策", 2);
        //对Map按值进行排序
        List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println("转化为List按值排序，并遍历");
        for (Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        List<Entry<String, Integer>> list2 = new ArrayList<>(map.entrySet());
        Collections.sort(list2, (o1, o2) -> {
            return o1.getKey().compareTo(o2.getKey());
        });
        System.out.println("转化为List按键排序，并遍历");
        for (Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        map.remove("李策");
        System.out.println("map.entrySet()遍历");
        for (Entry<String, Integer> items : map.entrySet()) {
            System.out.println(items.getKey() + ": " + items.getValue());
        }


        System.out.println("iterator迭代器遍历");
        Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Integer> items = it.next();
            System.out.println(items.getKey() + ": " + items.getValue());
        }

        System.out.println("lambda遍历1");
        map.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
    }

    public static void testLinkedHashMap() {
        Map<String, Integer> map = new LinkedHashMap<>();
        String[] persons = {"丹丹", "马小迪", "李策", "丹丹"};

        for (String s : persons) {
            map.put(s, !map.containsKey(s) ? 1 : map.get(s) + 1);
        }
        //map.putIfAbsent("丹丹",1);
        //通过键集合keyset遍历
        for (String s : map.keySet()) {
            System.out.println(s + ": " + map.get(s));
        }

        map.put("李策", 2);

        System.out.println("map.entrySet()遍历");
        for (Entry<String, Integer> items : map.entrySet()) {
            System.out.println(items.getKey() + ": " + items.getValue());
        }
        map.remove("李策");

        System.out.println("iterator迭代器遍历");
        Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Integer> items = it.next();
            System.out.println(items.getKey() + ": " + items.getValue());
        }

        System.out.println("lambda遍历1");
        map.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
    }

    public static void testTreeMap() {
        Map<String, Integer> map = new TreeMap<>();
        String[] persons = {"丹丹", "马小迪", "李策", "丹丹"};

        for (String s : persons) {
            /*if(!map.containsKey(s)){
                map.put(s,1);
            }else{
                map.put(s,map.get(s)+1);
            }*/
            map.put(s, !map.containsKey(s) ? 1 : map.get(s) + 1);
        }
        //map.putIfAbsent("丹丹",1);
        //通过键集合keyset遍历
        for (String s : map.keySet()) {
            System.out.println(s + ": " + map.get(s));
        }

        map.put("李策", 2);

        System.out.println("map.entrySet()遍历");
        for (Entry<String, Integer> items : map.entrySet()) {
            System.out.println(items.getKey() + ": " + items.getValue());
        }
        map.remove("李策");

        System.out.println("iterator迭代器遍历");
        Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Integer> items = it.next();
            System.out.println(items.getKey() + ": " + items.getValue());
        }

        System.out.println("lambda遍历1");
        map.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
    }
}
