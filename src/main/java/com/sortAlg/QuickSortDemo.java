package com.sortAlg;

/**
 * @author xyf
 * @Data Created in 18:23 2018/6/13
 * @Descriptions    快速排序
 *      快速排序是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序n个元素要O(nlogn)次比较。在最坏状况下则需要O(n^2)次比较，
 *      但这种状况并不常见。事实上，快速排序通常明显比其他O(nlogn)算法更快，因为它的内部循环可以在大部分的架构上很有效率地被实现出来。
 *
 * 快速排序使用分治策略(Divide and Conquer)来把一个序列分为两个子序列。步骤为：
 *      1.从序列中挑出一个元素，作为"基准"(pivot).
 *      2.把所有比基准值小的元素放在基准前面，所有比基准值大的元素放在基准的后面（相同的数可以到任一边），这个称为分区(partition)操作。
 *      3.对每个分区递归地进行步骤1~2，递归的结束条件是序列的大小是0或1，这时整体已经被排好序了。
 * 性能：
 *      分类 ------------ 内部比较排序
 *      数据结构 --------- 数组
 *      最差时间复杂度 ---- 每次选取的基准都是最大（或最小）的元素，导致每次只划分出了一个分区，需要进行n-1次划分才能结束递归，时间复杂度为O(n^2)
 *      最优时间复杂度 ---- 每次选取的基准都是中位数，这样每次都均匀的划分出两个分区，只需要logn次划分就能结束递归，时间复杂度为O(nlogn)
 *      平均时间复杂度 ---- O(nlogn)
 *      所需辅助空间 ------ 主要是递归造成的栈空间的使用(用来保存left和right等局部变量)，取决于递归树的深度，一般为O(logn)，最差为O(n)
 *      稳定性 ---------- 不稳定
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
