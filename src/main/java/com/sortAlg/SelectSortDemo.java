package com.sortAlg;

/**
 * @author xyf
 * @Data Created in 15:49 2018/6/13
 * @Descriptions    选择排序    每一趟从待排序序列选择一个最小的元素放到已排好序序列的末尾，剩下的为待排序序列，重复上述步骤直到完成排序。
 * 性能：
 *      分类 -------------- 内部比较排序
 *      数据结构 ---------- 数组
 *      最差时间复杂度 ---- O(n^2)
 *      最优时间复杂度 ---- O(n^2)
 *      平均时间复杂度 ---- O(n^2)
 *      所需辅助空间 ------ O(1)
 *      稳定性 ------------ 不稳定
 */
public class SelectSortDemo {

    public static void main(String[] args) {
        int[] numbers={-1, 0, 50, 44, -90};
        selectSort(numbers);
        for(int number : numbers) {
            System.out.println(number);
        }
    }

    private static void selectSort(int arr[]){
        int n;
        for(int i=0;i<arr.length-1;i++){
            int index=i;
            for(int j=i+1; j<arr.length;j++){
                if(arr[index]>arr[j]){
                    index=j;
                }
            }
            if(index!=i){
                n=arr[index];
                arr[index]=arr[i];
                arr[i]=n;
            }
        }
    }
}
