package com.circle.thread;

public class ThreadFirst implements Runnable{

    public ThreadFirst(String name){
        System.out.println(name);
    }

    public static void main(String[] args) {
        ThreadFirst first  = new ThreadFirst("22222222");
        ThreadFirst second = new ThreadFirst("33333");

        while (true){
            System.out.println(Thread.currentThread().getName());
            first.run();
            second.run();
            System.out.println(Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        System.out.println("1111");
    }
}
