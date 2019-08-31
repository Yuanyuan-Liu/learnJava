package com.circle.shangtang;

import java.util.Scanner;
import java.util.Stack;

public class NBL {
    private static void evoe(String[] strArr){
        String str = "+-*/";
        Stack<String> stack = new Stack<String>();
        //2.0遍历数组中的每一个元素
        for(String s : strArr){
            if(!str.contains(s)){//如果是数字,放入栈中
                stack.push(s);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch(s){
                    case "+" :
                        stack.push(String.valueOf(a+b));
                        break;
                    case "-" :
                        stack.push(String.valueOf(b-a));
                        break ;
                    case "*" :
                        stack.push(String.valueOf(a*b));
                        break;
                    case "/" :
                        stack.push(String.valueOf(b/a));
                        break ;
                }
            }
        }
        System.out.println(stack.pop());
    }
    public static void main(String[] args) {
        //1.0创建数组
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String [] strArr = str.split(" ");
        evoe(strArr);
    }
}
