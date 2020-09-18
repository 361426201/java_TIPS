package com.liuxing.util;

/**
 * @author ymy
 * @ClassName Print
 * @Description 打印
 * @date 2020/9/17 11:13
 */
public class Print {

    /***
     * 打印数据
     * @param arr 数组
     * @param length 数组长度
     */
    public static void print(int[] arr, int length) {
        for (int i = 0; i < length; ++i) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println("");
    }


}
