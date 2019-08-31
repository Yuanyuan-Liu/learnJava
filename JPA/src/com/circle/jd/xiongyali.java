package com.circle.jd;

import java.util.Scanner;

public class xiongyali {
    /**
     * 匈牙利算法解决最优指派问题
     * @author Hao
     *
     */

        public static void appoint(int[][] m){
            int N = m.length;
            //行规约
            for(int i = 0;i < N;i ++){
                int min = Integer.MAX_VALUE;
                for(int j = 0;j < N;j ++){
                    if(m[i][j] < min)
                        min = m[i][j];
                }
                for(int j = 0;j < N;j ++)
                    m[i][j] -= min;
            }
            //列规约
            for(int j = 0;j < N;j ++){
                double min = Double.MAX_VALUE;
                for(int i = 0;i < N;i ++){
                    if(m[i][j] < min)
                        min = m[i][j];
                }
                if(min == 0)
                    continue;
                for(int i = 0;i < N;i ++)
                    m[i][j] -=min;
            }

            printM(m);

            //进行试分配
            while(true){
                boolean zeroExist = true;
                while(zeroExist){
                    zeroExist = false;
                    if(rowAppoint(m))
                        zeroExist = true;
                    if(colAppoint(m))
                        zeroExist = true;
                    printM(m);
                }
                //判断是否达到最优分配
                if(isOptimal(m))
                    break;

                //变换矩阵
                updataM(m);

                //将0元素恢复
                for(int i = 0;i < N;i ++){
                    for(int j = 0;j < N;j ++)
                        if(m[i][j]<0)
                            m[i][j] = 0;
                }

                printM(m);
            }
        }

        public static void updataM(int[][] m){
            int N = m.length;
            //记录行、列是否打钩
            boolean[] rowIsChecked = new boolean[N];
            boolean[] colIsChecked = new boolean[N];
            //给没有被圈的行打钩
            for(int i = 0;i < N;i ++){
                for(int j = 0;j < N;j ++){
                    if(m[i][j] == -1){
                        rowIsChecked[i] = false;
                        break;
                    }else{
                        rowIsChecked[i] = true;
                    }
                }
            }

            boolean isChecked = true;

            while(isChecked){
                isChecked = false;

                //对所有打钩行的0元素所在列打钩
                for(int i = 0;i < N;i ++){
                    if(rowIsChecked[i]){
                        for(int j = 0;j < N;j ++){
                            if(m[i][j]==-2 && !colIsChecked[j]){
                                colIsChecked[j] = true;
                                isChecked = true;
                            }
                        }
                    }
                }
                //对打钩列上的独立零元素行打钩
                for(int j = 0;j < N;j ++){
                    if(colIsChecked[j]){
                        for(int i = 0;i < N;i ++){
                            if(m[i][j] == -1 && !rowIsChecked[i]){
                                rowIsChecked[i] = true;
                                isChecked = true;
                            }
                        }
                    }
                }
            }

            //寻找盖零线以外最小的数
            double min = Double.MAX_VALUE;
            for(int i = 0;i < N;i ++){
                if(rowIsChecked[i]){
                    for(int j = 0;j < N;j ++){
                        if(!colIsChecked[j]){
                            if(m[i][j] < min)
                                min = m[i][j];
                        }
                    }
                }
            }

            //打钩各行减去min
            for(int i=0;i < N;i ++){
                if(rowIsChecked[i]){
                    for(int j = 0;j < N;j ++){
                        if(m[i][j] > 0)
                            m[i][j] -= min;
                    }
                }
            }

            //打钩各列加上min
            for(int j=0;j < N;j ++){
                if(colIsChecked[j]){
                    for(int i = 0;i < N;i ++){
                        if(m[i][j] > 0)
                            m[i][j] += min;
                    }
                }
            }

        }

        //统计被圈起来的0数量,判断是否找到最优解
        public static boolean isOptimal(int[][] m){
            int count = 0;
            for(int i = 0;i < m.length;i ++){
                for(int j = 0;j < m.length;j ++)
                    if(m[i][j] == -1)
                        count ++;
            }
            return count==m.length;
        }

        //寻找只有一个0元素的行，将其标记为独立0元素（-1），对其所在列的0元素画叉（-2）
        //若存在独立0元素返回true
        public static boolean rowAppoint(int[][] m){
            boolean zeroExist = false;
            int N = m.length;
            //寻找只有一个0元素的行（列）
            for(int i = 0;i < N;i ++){
                int zeroCount = 0;
                int colIndex = -1;
                for(int j = 0;j < N;j ++){
                    if(m[i][j]==0){
                        zeroCount ++;
                        colIndex = j;
                        zeroExist = true;
                    }
                }
                //将独立0元素标记为-1(被圈起来)，对应的列上的零标记为-2(被划去)
                if(zeroCount == 1){
                    m[i][colIndex] = -1;
                    for(int k = 0;k < N;k ++){
                        if(k == i)
                            continue;
                        else if(m[k][colIndex] == 0)
                            m[k][colIndex] = -2;
                    }
                }else if(zeroCount == 2){//如果存在2组解，随机选择其一标记，解决多解问题
                    if(Math.random()>0.95){
                        m[i][colIndex] = -1;
                        for(int k = 0;k < N;k ++){
                            if(k == i)
                                continue;
                            else if(m[k][colIndex] == 0)
                                m[k][colIndex] = -2;
                        }
                        for(int j = 0;j < N;j ++){
                            if(j == colIndex)
                                continue;
                            else if(m[i][j] == 0)
                                m[i][j] = -2;
                        }
                    }
                }
            }
            return zeroExist;
        }
        //寻找只有一个0元素的列，将其标记为独立0元素（-1），对其所在行的0元素画叉（-2）
        //若存在独立0元素返回true
        public static boolean colAppoint(int[][] m){
            boolean zeroExist = false;
            int N = m.length;
            for(int j = 0;j < N;j ++){
                int zeroCount = 0;
                int rowIndex = -1;
                for(int i = 0;i < N;i ++){
                    if(m[i][j]==0){
                        zeroCount ++;
                        rowIndex = i;
                        zeroExist = true;
                    }
                }
                if(zeroCount == 1){
                    m[rowIndex][j] = -1;
                    for(int k = 0;k < N;k ++){
                        if(k == j)
                            continue;
                        else if(m[rowIndex][k] == 0)
                            m[rowIndex][k] = -2;
                    }
                }
            }
            return zeroExist;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            int[] num = new int[str.length()];
            String[] strings = str.split(" ");
            int i =0;
            for(String s:strings){
                num[i] = Integer.parseInt(s);
                i++;
            }
            int[][] m = getMap(num[1]);
            appoint(m);

            printResult(m);
        }

        public static int[][] getMap(int m){
            Scanner sc = new Scanner(System.in);
            int[][] map = new int[m][];
            for(int i =0;i<m;i++){
                sc = new Scanner(System.in);
                String str = sc.nextLine();
                String[] strings = str.split(" ");
                for(int j=0;j<2;j++){
                    map[i][j] = Integer.parseInt(strings[j]);
                }
            }
            return map;
        }

        public static void printM(int[][] m){
//            System.out.println("---------------");
            for(int i = 0;i < m.length;i ++){
                for(int j = 0;j < m.length;j ++)
                    System.out.print(m[i][j] + " ");
                System.out.println();
            }
        }

        public static void printResult(int[][] m){
            System.out.println("-----Result------");
            for(int i = 0;i < m.length;i ++){
                for(int j = 0;j < m.length;j ++)
                    if(m[i][j] == -1)
                        System.out.print(i+"--"+j+", ");
            }
        }
    }
