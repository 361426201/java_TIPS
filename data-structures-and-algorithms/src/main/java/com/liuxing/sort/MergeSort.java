package com.liuxing.sort;

import com.liuxing.util.Print;

/**
 * @author liuxing007
 * @ClassName MergeSort
 * @Description 归并排序（Merge Sort）
 * 归并排序的核心思想还是蛮简单的。如果要排序一个数组，
 * 我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，
 * 再将排好序的两部分合并在一起，这样整个数组就都有序了。
 *
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 不是原地排序算法
 * @date 2020/9/17 15:04
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
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
        sortMerge(arr,0,l-1);
    }


    /**
     * 递归
     * @param arr 数组
     * @param p 开始位置下表
     * @param r 结束位置下表
     */
    private static void sortMerge(int[] arr,int p,int r){
        if(p >= r){
            return ;
        }
        //分治的下标，这里我采用p到r的中间位置index。
        int index = (p+r)/2;
        //左侧递归
        sortMerge(arr,p,index);
        //右侧递归
        sortMerge(arr, index + 1, r);
         merge(arr, p, index,r);
    }

    /**
     * 合并计算
     * @param arr 原素组
     * @param l 左侧数组开始位置下标
     * @param index 左侧数组结束位置下标
     * @param r 右侧数组结束位置下标
     */
    private static void merge(int[] arr, int l,int index, int r) {
        //临时数组，这里可以优化，数组的频繁创建会降低程序运行的效率，
        // 所以这里可以将这个临时数组改成参数传递进来，在数量较大的时候执行效率变化变焦显著
        int[] temp = new int[r-l+1];
        //左侧开始下标
        int i= l;
        //右侧开始下标
        int j = index+1;
        //临时数组下标
        int k=0;
        // 左侧数组与右侧数组进行对比，将小的元素放入临时数组中
        while(i<=l && j<=r){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        //对比完成之后，需要把两侧数组中还没有对比的数据加入到临时数组中
        //把左边剩余元素加入临时数组中
        while(i<=index){
            temp[k++] = arr[i++];
        }
        //把右边剩余元素加入临时数组中
        while(j<=r){
            temp[k++] = arr[j++];
        }
        //将临时数组的元素拷贝原数组中
        for(int x=0;x<temp.length;x++){
            arr[x+l] = temp[x];
        }
    }

}
