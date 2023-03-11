package org.example.test13;

import java.util.Arrays;
import java.util.Scanner;

public class shuati {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //接收用户输入
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        //记录程序运行起始时间
        long timeMillis = System.currentTimeMillis();

        //找中间值
        //1.1将数组copy(拷贝)一个一模一样的新数组
        //用到Arrays类的copyOfRange(int[] original, int from, int to)
        //需要特别注意的是范围[from,to)区间是左闭右开
        int[] copyarr = Arrays.copyOfRange(arr, 0, arr.length);
        System.out.println("拷贝的新数组" + Arrays.toString(copyarr));
        Arrays.sort(copyarr);
        System.out.println("拷贝的新数组排序后" + Arrays.toString(copyarr));
        System.out.println("中间值=" + copyarr[arr.length / 2]);
        int median = copyarr[arr.length / 2];

//        //第2步 循环arr与median比
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] < median) {
//                arr[i] = median+1-arr[i];
//            } else arr[i] = 0;
//        }


        //第3步 改代码!
//        int flag = 0;//建立一个是否+1的标志  默认不加
//        int less = 0;//记录小于中间值的数量
//        int more = 0;//记录大于中间值的数量
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > median) more++;
//            if (arr[i] < median) less++;
//        }
//    //  arr中 (大于中间值的数量)小于(小于中间值的数量）变成中间值
//    //      例如： 3  4  6  10  10  14  变成10
//    //  arr中 (大于中间值的数量)等于(小于中间值的数量）变成中间值+1
//    //      例如： 6  10 12 15  20      变成13
//    //  arr中 (大于中间值的数量)大于(小于中间值的数量）变成中间值+1
//    //      例如： 3  10 10 10  12  14  变成11
//        if (more >= less) flag = 1;
//
//        //第3步 改变arr
//        //循环arr与median比
//        //使得全班刷题比他多的学生数 不超过 刷题比他少的学生数。
//        for (int i = 0; i < arr.length; i++) {
//            //3  10   10    12  14  中间值 10要变大
//            //3  4    10    10  14  中间值 10不用变
//            if (arr[i] < median) {
//                arr[i] = median + flag - arr[i];
//            } else {
//                //这里等于中间值的 和 大于中间值的 arr[i] 都为 0是不对的 第四步有分析
//                arr[i] = 0;
//            }
//        }


        //3  10   10    12  14  中间值 10要变大
        //3  4    10    10  14  中间值 10不用变
        //3  4    10    12  14  中间值 10不用变

        //看第4步之前 把前3步先理解了
        //第4步 改代码!
        int flag = 0;//建立一个是否+1的标志 默认加1
        int midflag = 0; //再建立一个对 中间值  是否要+1的标志
        int less = 0;//记录小于中间值的数量
        int more = 0;//记录大于中间值的数量
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > median) {
                more++;
            }
            if (arr[i] < median) {
                less++;
            }
        }
        //  arr中 (大于中间值的数量)小于(小于中间值的数量）变成中间值    flag = 0
        //      例如： 3  4  6  10  10  14  变成10
        //  arr中 (大于中间值的数量)等于(小于中间值的数量）变成中间值+1  flag = 1
        //      例如： 6  10 12 15  20      变成13
        //  arr中 (大于中间值的数量)大于(小于中间值的数量）变成中间值+1  flag = 1
        //      例如： 3  10 10 10  12  14  变成11
        if (more >= less) {
            flag = 1;
        }
        //  arr中 (大于中间值的数量)小于(小于中间值的数量）时 中间值不用变 midflag = 0
        //3  4    10    12  14  中间值 10不用变    midflag = 0
        //  arr中 (大于中间值的数量)等于(小于中间值的数量）时 中间值不用变 midflag = 0
        //3  4    10    10  14  中间值 10不用变    midflag = 0
        //  arr中 (大于中间值的数量)大于(小于中间值的数量）时 中间值不用变 midflag = 1
        //3  10   10    12  14  中间值 10要变大    midflag = 1
        if (more > less) {
            midflag = 1;
        }

        //第4步  改变arr
        //循环arr与median比
        //使得全班刷题比他多的学生数 不超过 刷题比他少的学生数。
        for (int i = 0; i < arr.length; i++) {
            //3  10   10    12  14  中间值 10要变大
            //3  4    10    10  14  中间值 10不用变
            if (arr[i] < median) {
                //小于中间值的arr[i] 通过flag 分情况
                arr[i] = median + flag - arr[i];
            } else if (arr[i] == median && midflag == 1) {
                //等于中间值的arr[i]  通过midflag 分情况
                arr[i] = median + midflag - arr[i];
            } else {
                arr[i] = 0;
            }
        }

        //输出结果 注意：其元素中间有空格！！！
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");//不换行
        }
        System.out.print(arr[arr.length - 1]);

        //程序运行时间 = 程序结束时间-程序起始时间
        System.out.println("\n程序运行时间：" +
                (System.currentTimeMillis() - timeMillis) + "ms");

    }
}
