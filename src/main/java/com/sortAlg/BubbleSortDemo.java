package com.sortAlg;

/**
 * @author xyf
 * @Data Created in 14:40 2018/6/13
 * @Descriptions    冒泡排序算法实现
 *      每遍历一次，将最大的元素放到序列的最后，剩下的是待排序序列。重复上述步骤直到序列中元素是按照从小到大排列为止。
 * 性能：
 *      分类 -------------- 内部比较排序
 *      数据结构 ---------- 数组
 *      最差时间复杂度 ---- O(n^2)
 *      最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
 *      平均时间复杂度 ---- O(n^2)
 *      所需辅助空间 ------ O(1)
 *      稳定性 ------------ 稳定
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        bubbleSort(arr);
    }

    public static void bubbleSort(int arr[]){
        int t = 0;
        for(int i = 0; i<arr.length-1; i++){
            for(int j = 0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    t=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=t;
                }
            }
        }
        for(int a : arr)
            System.out.print(a);
    }
}
