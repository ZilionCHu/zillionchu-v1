package com.github.zillionchu.stop.zillionchustop.magic;

import java.util.Arrays;

/**
 * @Auther: ZiLlionChu
 * @Date: 2020/3/3 10:00
 * @Description:
 */
public class Code01_bubbleSort {


    public static void main(String[] args) {
        int[] ints = {1, 5, 7, 2, 8};
        long[] intss = {1, 5, 7, 2, 8};
        bubbleSort(ints);
        sort(intss);
        Arrays.stream(ints).forEach(value -> System.out.print(value));
        //Arrays.stream(intss).forEach(value -> System.out.print(value));
    }


    public static void bubbleSort(int[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            System.out.println("end is  : " + end +"  arr[end] is  :" + arr[end]);
            for (int i = 0; i < end; i++) {
                System.out.println("i is  :" + i  +"  arr[i] is :" + arr[i]) ;
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }

    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }


    public static void sort(long[] arr) {
        long tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {//冒泡次数
            for (int j = 0; j < arr.length - 1 - i; j++) {//比较的次数
                if (arr[j] > arr[j + 1]) {//加入前面的元素小于后面的元素 调换位置
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

}
