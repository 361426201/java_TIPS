package com.liuxing.sort;

import com.liuxing.util.Print;

/**
 * @author liuxing007
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，
 * 看是否满足大小关系要求。如果不满足就让它俩互换。一次冒泡会让至少一个元素移动到它应该在的位置，
 * 重复 n 次，就完成了 n 个数据的排序工作。
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 是原地排序算法
 * @date 2020/9/17 10:45
 */
public class BubbleSort {


    /**
     * 冒泡排序具体实现
     *
     * @param arr
     * @param length
     */
    private static void sort(int[] arr, int length) {
        if (length < 1) {
            System.out.println("数组中没有数据");
            return;
        }
        for (int i = 0; i < length; ++i) {
            //设置退出冒泡的标志
            boolean flag = false;
            //解释一下：length - i,冒泡一次之后就会有一个元素到达指定的位置，我这里比找最大的元素，
            // 所以经理一次冒泡之后最右边永远是对打的元素，所以剩下的元素就不需要再和它比较。
            for (int j = 0; j < (length - i) - 1; ++j) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                //如果flag=false，没有交换过数据，说明此数组本来就是有序，所以直接可以提前结束
                break;
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
