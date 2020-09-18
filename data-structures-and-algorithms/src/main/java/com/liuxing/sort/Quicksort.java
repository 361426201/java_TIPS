package com.liuxing.sort;

import com.liuxing.util.DataUtil;
import com.liuxing.util.Print;

/**
 * @author liuxing007
 * @ClassName Quicksort
 * @Description 快速排序
 *
 * 如果要排序数组中下标从 p 到 r 之间的一组数据，
 * 我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 * 我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，
 * 将大于 pivot 的放到右边，将 pivot 放到中间。经过这一步骤之后，
 * 数组 p 到 r 之间的数据就被分成了三个部分，
 * 前面 p 到 q-1 之间都是小于 pivot 的，中间是 pivot，
 * 后面的 q+1 到 r 之间是大于 pivot 的.
 * 根据分治、递归的处理思想，
 * 我们可以用递归排序下标从 p 到 q-1 之间的数据和下标从 q+1 到 r 之间的数据，
 * 直到区间缩小为 1，就说明所有的数据都有序了（摘自-极客时间-数据结构与算法-王争）
 *
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 原地排序算法，但不是稳点排序算法
 * @date 2020/9/18 10:22
 */
public class Quicksort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
//        int[] arr = DataUtil.createIntArrData();
        int length = arr.length;
        System.out.println("排序前数组===========");
        Print.print(arr, length);
        sort(arr, length);
        System.out.println("排序后数组===========");
        Print.print(arr, length);
    }

    /**
     * 排序算法
     * @param arr 数组
     * @param l 数组长度
     */
    private static void sort(int[] arr,int l){
        sortRec(arr,0,l-1);
    }

    /**
     * 递归
     * @param arr
     * @param p
     * @param r
     */
    private static void sortRec(int[] arr, int p, int r) {
        //递归终止条件
        if (p >= r){
            return;
        }
        //获取分区点
        int q = partition(arr, p, r);
        //左侧递归
        sortRec(arr, p, q-1);
        //右侧递归
        sortRec(arr, q+1, r);
    }

    /**
     * 分区
     * @param arr 原始数组
     * @param p 数组起始下标
     * @param r 数组结束下标
     * @return  分区下标
     */
    private static int partition(int[] arr, int p, int r) {
        //取最后一个元素作为分区的值
        int pivot = arr[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (arr[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    //交换位置
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        //交换位置
        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;
        return i;
    }


}
