package com.liuxing.sort;

import com.liuxing.util.Print;

/**
 * @author liuxing007
 * @ClassName SelectionSort
 * @Description 选择排序（Selection sort）是一种简单直观的排序算法。
 * 它的工作原理是：第一次从待排序的数据元素中选出最小（或最大）的一个元素，
 * 存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小（大）元素，
 * 然后放到已排序的序列的末尾。以此类推，直到全部待排序的数据元素的个数为零。
 * 选择排序是不稳定的排序方法。
 *
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 不是原地排序算法
 * @date 2020/9/17 11:28
 */
public class SelectionSort {

    /**
     * 插入排序具体实现
     * @param arr 数组
     * @param length 数组长度
     */
    private static void sort(int[] arr, int length) {
        if (length < 1) {
            System.out.println("数组中没有数据");
            return;
        }
        for(int i = 0; i < length; ++i){
            //最小元素下标
            int minIndex = i;
            //从i+1开始对比
            int j = i+1;
            for(; j< length; ++j){
                if(arr[j] <arr[minIndex]){
                    minIndex = j;
                }
            }
            if(i != minIndex){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 冒泡测试
     * 定义一个无序的数组，通过冒泡排序将此数组变成有序   [6,5,4,3,2,1]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        int length = arr.length;
        System.out.println("排序前数组===========");
        Print.print(arr, length);
        sort(arr, length);
        System.out.println("排序后数组===========");
        Print.print(arr, length);
    }

}
