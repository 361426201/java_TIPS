package com.liuxing.util;


/**
 * @author liuxing007
 * @ClassName DataUtil
 * @Description 数据工具类
 * @date 2020/9/18 14:17
 */
public class DataUtil {

    /**
     * 生成数据  默认100000
     * @return
     */
    public static int[] createIntArrData(){
        return createIntArrData(100000);
    }


    /**
     * 生成指定长度的数组数据
     * @param length 数组长度
     * @return
     */
    public static int[] createIntArrData(int length){
        int[] arr = new int[length];
        for(int i = 0; i<length;++i){
            arr[i] = (int) (Math.random() * length+1);
        }
        return arr;
    }

}
