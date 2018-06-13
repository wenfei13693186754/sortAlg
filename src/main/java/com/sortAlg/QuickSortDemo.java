package com.sortAlg;

/**
 * @author xyf
 * @Data Created in 18:23 2018/6/13
 * @Descriptions    快速排序
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int arr[] = {1,4,2,8,-2,233};
        quickSort(arr,0,5);
        for(int a : arr){
            System.out.println(a);
        }
    }
    public static void quickSort(int array[], int low, int high) {// 传入low=0，high=array.length-1;
        int pivot, p_pos, i, t;// pivot->位索引;p_pos->轴值。
        if (low < high) {
            p_pos = low;
            pivot = array[p_pos];
            for (i = low + 1; i <= high; i++)
                if (array[i] > pivot) {
                    p_pos++;
                    t = array[p_pos];
                    array[p_pos] = array[i];
                    array[i] = t;
                }
            t = array[low];
            array[low] = array[p_pos];
            array[p_pos] = t;
            // 分而治之
            quickSort(array, low, p_pos - 1);// 排序左半部分
            quickSort(array, p_pos + 1, high);// 排序右半部分
        }
    }
}
