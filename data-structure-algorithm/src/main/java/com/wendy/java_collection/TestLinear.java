package com.wendy.java_collection;

import java.util.*;

public class TestLinear {
    public static void main(String[] args) {
        testArraylist();

        //testLinkedlist();

        //testPriorityQueue();

    }

    public static void testArraylist(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(3);
/*        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });*/
        Collections.sort(list, (o1,o2)->o1-o2);


        //for循环遍历Arraylist
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("---------------------------");
        //增强for遍历
        for(Integer i: list){
            System.out.println(i);
        }

        System.out.println("\n第三种遍历方式：迭代器遍历 List 集合");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //改变元素
        list.set(1,6);//改变位置1处的值
        Collections.sort(list,(o1,o2)->{return o1-o2;});
        // Lambda 表达式遍历（JDK 1.8）
        System.out.println("\n第四种遍历方式：Lambda 表达式遍历 List 集合");
        list.forEach(item->{
            System.out.println(item);
        });
        //删除元素
        list.remove(0);

        // Lambda 表达式遍历（JDK 1.8）
        System.out.println("\n第5种遍历方式：简化Lambda 表达式遍历 List 集合");
        list.forEach(System.out::println);
    }

    public static void testLinkedlist(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("lidan");
        linkedList.add("wendy");
        linkedList.add("baby");

        //for循环遍历
        for(int i=0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
        }
        System.out.println("--------------------");
        //增强for
        for(String s:linkedList){
            System.out.println(s);
        }
        linkedList.set(1,"baobei");

        //lambda表达式遍历1
        System.out.println("lambda表达式遍历");
        linkedList.forEach(items->{
            System.out.println(items);
        });

        linkedList.remove(2);
        //lambda表达式遍历1
        linkedList.forEach(System.out::println);
    }

    public static void testPriorityQueue(){
        //默认创建一字母大小排序
        //Queue<String> priorityQueue = new PriorityQueue();

        //自定义比较器以字符串长度排序
        Comparator<String> cmp = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length()-s2.length();
            }
        };

        Queue<String> priorityQueue = new PriorityQueue<>(cmp);
        priorityQueue.add("dandan");
        priorityQueue.add("wendy");
        priorityQueue.add("cece");

        //迭代器遍历
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("----------------");

        //lambda遍历1
        priorityQueue.forEach(items->{
            System.out.println(items);
        });
        //lambda遍历2
        priorityQueue.forEach(System.out::println);

        System.out.println("----------------");

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
        System.out.println("----------------");

    }

}
