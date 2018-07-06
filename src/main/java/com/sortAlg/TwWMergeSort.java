package com.sortAlg;

import java.util.Arrays;

/**
 * @author xyf
 * @Data Created in 11:09 2018/7/6
 * @Descriptions   归并排序的实现分为递归实现和非递归（迭代）实现，递归实现的归并排序是使用了分而治之的思想，将一个大问题分割成小问题并分别解决，
 *              然后，用所有小问题的答案来解决整个大问题。非递归（迭代）实现的归并排序首先进行两两归并，然后四四归并，一致下去直到归并了整个数组。
 *                  归并排序和堆排序都是基于完全二叉树实现的。
 * 性能：
 *      分类 -------------- 内部比较排序
 *      数据结构 ---------- 数组
 *      最差时间复杂度 ---- O(nlogn)
 *      最优时间复杂度 ---- O(nlogn)
 *      平均时间复杂度 ---- O(nlogn)
 *      所需辅助空间 ------ O(n)
 *      稳定性 ------------ 稳定
 */
public class TwWMergeSort {
    public static void main(String args[]) {
        int a[] = {3, 6, 1, 7, 9, 4, 5, 8, 2};
        mergeSort(a);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    private static void mergeSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, temp, left, center); // 左边
            mergeSort(arr, temp, center + 1, right); // 右边
            merge(arr, temp, left, center + 1, right); // 合并两个有序
        }
    }

    /**
     * @param temp     临时数组
     * @param leftPos  左边开始下标
     * @param rightPos 右边开始下标
     * @param rightEnd 右边结束下标
     * @return
     * @Data Created in 11:09 2018/7/6
     * @Descriptions    将两个有序表归并成一个有序表
     */
    private static void merge(int[] arr, int[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1; // 左边结束下标
        int tempPos = leftPos; // 从左边开始算
        int numEle = rightEnd - leftPos + 1; // 元素个数
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] <= arr[rightPos])
                temp[tempPos++] = arr[leftPos++];
            else
                temp[tempPos++] = arr[rightPos++];
        }
        while (leftPos <= leftEnd) {  // 左边如果有剩余
            temp[tempPos++] = arr[leftPos++];
        }
        while (rightPos <= rightEnd) { // 右边如果有剩余
            temp[tempPos++] = arr[rightPos++];
        }
        // 将temp复制到arr
        for (int i = 0; i < numEle; i++) {
            arr[rightEnd] = temp[rightEnd];
            rightEnd--;
        }
    }
}
