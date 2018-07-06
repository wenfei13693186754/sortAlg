package com.sortAlg;

/**
 * @author xyf
 * @Data Created in 10:49 2018/7/6
 * @Descriptions    堆排序 核心是步骤：1.构造大顶堆或者小顶堆；2.，将大顶堆中根节点的元素与叶子节点的小元素进行交换，之后再重构大顶堆。
 * 性能：
 *      分类 -------------- 内部比较排序
 *      数据结构 ---------- 数组
 *      最差时间复杂度 ---- O(nlogn)
 *      最优时间复杂度 ---- O(nlogn)
 *      平均时间复杂度 ---- O(nlogn)
 *      所需辅助空间 ------ O(1)
 *      稳定性 ------------ 不稳定
 *
 *      总的来说是时间复杂度和空间复杂度都相对较低的排序算法，但是因为初次构建堆的时候需要比较次数较多，故不适合数据量比较大的情况
 */
public class HeapSort {
    public static void main(String[] args)
    {
        int[] array=new int[]{1,2,3,4,7,8,9,10,14,16};
        MaxHeap heap=new MaxHeap(array);
        System.out.println("执行最大堆化前堆的结构：");
//        执行最大堆化前堆的结构：
//        1
//        2 3
//        4 7 8 9
//        10 14 16
        printHeapTree(heap.heap);
        heap.BuildMaxHeap();
        System.out.println("执行最大堆化后堆的结构：");
//        执行最大堆化后堆的结构：
//        16
//        14 9
//        10 7 8 3
//        1 4 2
        printHeapTree(heap.heap);
        heap.HeapSort();
        System.out.println("执行堆排序后数组的内容");
//        执行堆排序后数组的内容
//        1 2 3 4 7 8 9 10 14 16
        printHeap(heap.heap);

    }
    private static void printHeapTree(int[] array)
    {
        for(int i=1;i<array.length;i=i*2)
        {
            for(int k=i-1;k<2*(i)-1&&k<array.length;k++)
            {
                System.out.print(array[k]+" ");
            }
            System.out.println();
        }
    }
    private static void printHeap(int[] array)
    {
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
    }


}

class MaxHeap {
    int[] heap;
    int heapsize;
    public MaxHeap(int[] array)
    {
        this.heap=array;
        this.heapsize=heap.length;
    }
    public void BuildMaxHeap()
    {
        for(int i=heapsize/2-1;i>=0;i--)
        {
            Maxify(i);//依次向上将当前子树最大堆化
        }
    }
    public void HeapSort()
    {
        for(int i=0;i<heap.length;i++)
        {
            //执行n次，将每个当前最大的值放到堆末尾
            int tmp=heap[0];
            heap[0]=heap[heapsize-1];
            heap[heapsize-1]=tmp;
            heapsize--;
            Maxify(0);
        }
    }
    public void Maxify(int i)
    {
        int l=Left(i);
        int r=Right(i);
        int largest;

        if(l<heapsize&&heap[l]>heap[i])
            largest=l;
        else
            largest=i;
        if(r<heapsize&&heap[r]>heap[largest])
            largest=r;
        if(largest==i||largest>=heapsize)//如果largest等于i说明i是最大元素 largest超出heap范围说明不存在比i节点大的子女
            return ;
        int tmp=heap[i];//交换i与largest对应的元素位置，在largest位置递归调用maxify
        heap[i]=heap[largest];
        heap[largest]=tmp;
        Maxify(largest);
    }
    public void IncreaseValue(int i,int val)
    {
        heap[i]=val;
        if(i>=heapsize||i<=0||heap[i]>=val)
            return;
        int p=Parent(i);
        if(heap[p]>=val)
            return;
        heap[i]=heap[p];
        IncreaseValue(p, val);
    }

    private int Parent(int i)
    {
        return (i-1)/2;
    }
    private int Left(int i)
    {
        return 2*(i+1)-1;
    }
    private int Right(int i)
    {
        return 2*(i+1);
    }
}
