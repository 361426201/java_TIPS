package com.liuxing.sort;

import com.liuxing.util.Print;

/**
 * @author ymy
 * @ClassName MergeSort
 * @Description 归并排序（Merge Sort）
 * 归并排序的核心思想还是蛮简单的。如果要排序一个数组，
 * 我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，
 * 再将排好序的两部分合并在一起，这样整个数组就都有序了。
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
    private static int[] sortMerge(int[] arr,int p,int r){
        if(p >= r){
            return arr;
        }
        //分治的下标，这里我采用p到r的中间位置index。
        int index = (p+r)/2;
        //左侧递归
        sortMerge(arr,p,index);
        //右侧递归
        sortMerge(arr, index + 1, r);
         merge(arr, p, r,index);
         return null;
    }


    private static int[] merge(int[] arr, int l, int r,int p) {
        //临时数组
        int[] tmp = new int[r-l+1];
        int i=l,j=p+1,k=l;

        while (true){
            if(i > p || j > r){
                break;
            }
            if(arr[i] <= arr[j]){
                tmp[k++] = arr[i++];
            }else{
                tmp[k++] = arr[j++];
            }
        }
        if(i < p){
            while (true){
                if(i > p){
                    break;
                }
                tmp[k++] = arr[i++];
            }
        }else{
            while (true){
                if(j > r){
                    break;
                }
                tmp[k++] = arr[j++];
            }
        }
        int n = l;
       for(;;){
           if(n > r){
               break;
           }
           arr[n] = tmp[n];
           n++;
       }
        return null;
    }

}
