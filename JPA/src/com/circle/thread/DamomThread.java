package com.circle.thread;

public class DamomThread {

        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread( ()-> {
                while (true){
                    try {
                        Thread.sleep(1000);
                        System.out.println("内部线程：正在执行。。。。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }) ;

            //开启守护进程
            thread.setDaemon(true);
            thread.start();

            Thread.sleep(2_000L );


            System.out.println("Main thread finished lifecycle !!!!!!!!!!");

        }
}
