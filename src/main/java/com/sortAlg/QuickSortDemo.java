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
        // =====使用快速排序法对表示8名运动员身高的数组heights进行从低到高的排序=====
        // A(181)、B(169)、C(187)、D(172)、E(163)、F(191)、G(189)、H(182)
        int[] heights = { 181, 169, 187, 172, 163, 191, 189, 182 };
        // 调用快速排序方法
        quickSort(heights, 0, heights.length - 1);
        // 输出排序后的结果
        for (int height : heights) {
            System.out.println(height);
        }
    }

    /**
     * 对指定的数组中索引从start到end之间的元素进行快速排序
     *
     * @param array 指定的数组
     * @param start 需要快速排序的数组索引起点
     * @param end 需要快速排序的数组索引终点
     */
    public static final void quickSort(int[] array, int start, int end) {
        // i相当于助手1的位置，j相当于助手2的位置
        int i = start, j = end;
        int pivot = array[i]; // 取第1个元素为基准元素
        int emptyIndex = i; // 表示空位的位置索引，默认为被取出的基准元素的位置
        // 如果需要排序的元素个数不止1个，就进入快速排序(只要i和j不同，就表明至少有2个数组元素需要排序)
        while (i < j) {
            // 助手2开始从右向左一个个地查找小于基准元素的元素
            while (i < j && pivot <= array[j]) {
                j--;
            }
            if (i < j) {
                // 如果助手2在遇到助手1之前就找到了对应的元素，就将该元素给助手1的"空位"，j成了空位
                array[emptyIndex] = array[j];
                emptyIndex = j;
            }

            // 助手1开始从左向右一个个地查找大于基准元素的元素
            while (i < j && array[i] <= pivot)
                i++;
            if (i < j) {
                // 如果助手1在遇到助手2之前就找到了对应的元素，就将该元素给助手2的"空位"，i成了空位
                array[emptyIndex] = array[emptyIndex = i];
            }
        }
        // 助手1和助手2相遇后会停止循环，将最初取出的基准值给最后的空位
        array[emptyIndex] = pivot;

        // =====本轮快速排序完成=====

        // 如果分割点i左侧有2个以上的元素，递归调用继续对其进行快速排序
        if (i - start > 1) {
            quickSort(array, 0, i - 1);
        }
        // 如果分割点j右侧有2个以上的元素，递归调用继续对其进行快速排序
        if (end - j > 1) {
            quickSort(array, j + 1, end);
        }
    }
}
