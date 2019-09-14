package com.circle.tiger;

import java.util.Stack;

public class kuohao {

    //检验{【】}【】括号匹配
        public static void main(String[] args) {
            int flag = 1, l;
            String s = "{}[)}[)(}]";
            int num = s.length();
            char[] arr = s.toCharArray();
            System.out.println(arr); //打印输出
            // Stack<> stack;
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < num; i++) {
                if ('{' == arr[i] || '(' == arr[i] || '[' == arr[i]) {
                    stack.push(arr[i]);
                } else {
                    if (stack.isEmpty()) {
                        flag = 1;
                    } else {
                        if (('}' == arr[i] && stack.pop() == '{') || ')' == arr[i] && stack.pop() == '('
                                || ']' == arr[i] && stack.pop() == '[') {
                            stack.pop();
                        }
                    }
                }
            }


            if (flag == 1 && stack.isEmpty())
                System.out.println("Yes");
            else {
                System.out.println("NO");
            }
        }
    }