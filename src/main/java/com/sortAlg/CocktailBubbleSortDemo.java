package com.sortAlg;

/**
 * @author xyf
 * @Data Created in 15:07 2018/6/13
 * @Descriptions    鸡尾酒冒泡排序
 *      鸡尾酒排序是对冒泡排序的一种改进，它的主要思路是，对于一组无规则的数字，先找到最大的数字放到最后一位，然后再反向
 * 找到最小的数字放到第一位，然后再找到第二大的数字放到倒数第二位，然后再找到第二小的数字放到第二位，以此类推，最终实现排序。
 * 性能：
 *      分类 -------------- 内部比较排序
 *      数据结构 ---------- 数组
 *      最差时间复杂度 ---- O(n^2)
 *      最优时间复杂度 ---- 如果序列在一开始已经大部分排序过的话,会接近O(n)
 *      平均时间复杂度 ---- O(n^2)
 *      所需辅助空间 ------ O(1)
 *      稳定性 ------------ 稳定
 */
public class CocktailBubbleSortDemo {
    public static void main(String args[]) {
        int[] numbers={-1, 0, 50, 44, -90};
        cocktailBubbleSort(numbers);
        for(int number : numbers) {
            System.out.println(number);
        }
    }

    private static int[] cocktailBubbleSort(int arr[]){
        int t;
        int n = 0, m = arr.length-1;
        while(n<m){
            for(int i=n; i<m;i++){
                if(arr[i]>arr[i+1]){
                    t = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=t;
                }
            }
            m--;
            for(int j=m;j>n;j--){
                if(arr[j]<arr[j-1]){
                    t=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=t;
                }
            }
            n++;
        }
        return arr;
    }
}