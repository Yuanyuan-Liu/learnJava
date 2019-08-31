package com.circle.wenwalk;

    import java.util.Scanner;
    public class Count{
        public static void main(String[] args) {
            //接受键盘输入
            Scanner sc = new Scanner(System.in);
            String num = sc.nextLine();
            String[] numArray = num.split(",");
            int[] nums = new int[numArray.length];
            //将输入类型转换成int
            for(int i= 0 ;i< numArray.length ;i++) {
                nums[i] = Integer.parseInt(numArray[i]);
            }
            //调用数组
            System.out.print(getStep(nums));
        }

        public static int getStep(int[] nums){
            //输入数组长度<=2,走一步完成
            if(nums.length<=2){
                System.out.println("1");
            }
            int n = nums.length;
            int count = 0;
            int left;	//左边界		控制搜索的起始位置
            int right;	//右边界		控制搜索的终止位置
            int[] result = new int[n];
            for(int i = 0 ; i<n && nums[i]!= 0 ; count++) { //外层遍历数组元素
                right = i + nums[i];  //最右
                left = i + 1;  //最左
                for(int j= i+1 ;j< n && j<=i + nums[i] ;j++) {
                    if(j+nums[j] >= right){	//遍历可到达位置 能到达的最远位置
                        right = j+ nums[j];	//更新左右边界
                        left = j;
                        result[count]=j-i;  //对于外层遍历的每一层，得到一个值放到result数组中
                    }
                }
                i = left;	//左边界
            }
            return count;
        }
    }
