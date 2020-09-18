package com.liuxing.sort;

import com.liuxing.util.Print;

/**
 * @author liuxing007
 * @ClassName InsertionSort
 * @Description 插入排序，一般也被称为直接插入排序。对于少量元素的排序，它是一个有效的算法。
 * 插入排序是一种最简单的排序方法，它的基本思想是将一个记录插入到已经排好序的有序表中，
 * 从而一个新的、记录数增1的有序表。在其实现过程使用双层循环，
 * 外层循环对除了第一个元素之外的所有元素，
 * 内层循环对当前元素前面有序表进行待插入位置查找，并进行移动
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 是原地排序算法
 * @date 2020/9/17 11:09
 */
public class InsertionSort {

    /**
     * 插入排序具体实现
     * @param arr
     * @param length
     */
    private static void sort(int[] arr, int length) {
        if (length < 1) {
            System.out.println("数组中没有数据");
            return;
        }
        for (int i = 1; i < length; ++i) {
            int value = arr[i];
            //插入的位置
            int j = i - 1;
            for (; j >= 0; --j) {
                if (arr[j] > value) {
                    //元素移动
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            //插入
            arr[j + 1] = value;
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
