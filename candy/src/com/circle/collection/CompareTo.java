package com.circle.collection;

import java.util.*;

public class CompareTo {
    static  List<String> nameList = new ArrayList<>();
    static  List<Student> stuList = new ArrayList<>();

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello world I have a big dream my friends so sing songs".split(" "));

        List<String> copList = Arrays.asList("my boyfriends likes to play games".split(" "));

        System.out.println("-------------list-------------111111------------------------");
        for(String tt:list){
            System.out.println(tt);
        }

        Collections.copy(list,copList);

        System.out.println("-------------list------------222222-------------------------");
        for(String tt1:list){
            System.out.println(tt1);
        }

/*
        nameList.add("aaa");
        nameList.add("abc");
        nameList.add("bca");
        nameList.add("ddd");
        Collections.sort(nameList);
        for(String s:nameList){
            System.out.println(s);
        }

        stuList.add(new Student("mary",21,99.5f));
        stuList.add(new Student("tom",19,67.5f));
        stuList.add(new Student("lisa",23,78.5f));
        stuList.add(new Student("papa",20,99.5f));
        stuList.add(new Student("circle",19,99.5f));
        stuList.add(new Student("bob",21,99.5f));
        stuList.add(new Student("apple",25,99.5f));
        stuList.add(new Student("rice",22,99.5f));
        stuList.add(new Student("jack",27,89f));
        stuList.add(new Student("grace",24,88.5f));

        Collections.sort(stuList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(Student stu:stuList){
            System.out.println(stu.toString());
        }*/
    }
}
