package com.circle.didi;

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;
import java.util.Stack;

public class CaculatorTransform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc = new Scanner(System.in);
        String str = sc.nextLine();
//        String[] numArray = num.split(" ");

        //将输入类型转换成int
        getResult(str);
    }

    public static void getResult(String string){
        String str = "+-*/";

        Stack<Integer> stack = new Stack<Integer>();

        //2.0遍历数组中的每一个元素

        for(int i =0 ;i<string.length();i++){

            char c = string.charAt(i);
            for(int j =0 ;j<str.length();j++){
                if(str.charAt(j) != string.charAt(i)){//如果是数字,放入栈中
                    stack.push(Integer.parseInt(String.valueOf(string.charAt(i))));
                }else{
                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
                    switch(string.charAt(i)){
                        case '+' :
                            stack.push(a+b);
                            break;
                        case '-' :
                            stack.push(b-a);
                            break ;
                        case '*' :
                            stack.push(a*b);
                            break;
                        case '/' :
                            stack.push(b/a);
                            break ;
                    }
                }
            }

        }
        System.out.println(stack.pop());
    }
}