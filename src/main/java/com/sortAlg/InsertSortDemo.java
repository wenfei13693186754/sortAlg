package com.sortAlg;

/**
 * @author xyf
 * @Data Created in 17:38 2018/6/13
 * @Descriptions 插入排序   类似于扑克牌。对于未排序的数据（右手抓到的牌），再已排序（左手已排序号的牌）中从后向前扫描，找到相应位置并插入。
 *                      插入排序实现上，通常采用in-place排序（即只需要用到O（1）额外空间），因而再从后向前扫描过程中，需要反复把已排序元素逐
 *                      步向后挪动，为新元素提供插入空间
 * 具体实现：
 *      1.从第一个元素开始，该元素可以认为已经被排序
 *      2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 *      3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 *      4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 *      5.将新元素插入到该位置后
 *      6.重复步骤2~5
 * 性能：
 *      分类 ------------- 内部比较排序
 *      数据结构 ---------- 数组
 *      最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
 *      最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
 *      平均时间复杂度 ---- O(n^2)
 *      所需辅助空间 ------ O(1)
 *      稳定性 ------------ 稳定
 */
public class InsertSortDemo {
    public static void main(String[] args) {
        int arr[] = {5, 3, 6, 9, 2, 7, 3};
        insertSort(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    private static void insertSort(int arr[]){
        int i,j,n;
        for(i=1;i<arr.length;i++){
            n=arr[i];
            for(j=i-1;j>=0;j--){
                if(n<arr[j]){
                    arr[j+1]=arr[j];
                }
            }
            arr[j+1]=n;
        }
    }
}


