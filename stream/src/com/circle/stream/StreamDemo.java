package com.circle.stream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
       List<String> filters=strings.stream().filter(s ->s.startsWith("a")).sorted().collect(Collectors.toList());
       for(String s:filters){
           System.out.println(s);
       }


        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

    }



}
