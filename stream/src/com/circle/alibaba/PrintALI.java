package com.circle.alibaba;

public class PrintALI {
    public static void main(String... args) throws InterruptedException {
        while (true){
            Thread t1 = new Thread(() -> System.out.println("a"));
            Thread t2 = new Thread(() -> System.out.println("l"));
            Thread t3 = new Thread(() -> System.out.println("i"));
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        }
    }
}
