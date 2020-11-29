package algorithm.heap;

/**
 * @description: 堆与堆排序是两回事。 建好一个大根堆和小根堆（以大根堆为例，只要符合所有的父节点都>=子节点，就可以称为一个大根堆）。
 *              而堆排序是在其基础上进行排序，使得排好序的堆层序遍历符合从小到大（或从大到小），其中顺序先建大根堆，逆序先建小根堆，其次依次把堆顶元素与最后一个元素交换，保证每次交换后都符合大小根堆的特性，最后就是堆排序的结果。
 * @author: Sun, YaSong
 * @time: 2020/9/28 12:13
 */
public class Heap {
    private int[] arr;

    public Heap(int[] arr) {
        this.arr = arr;
        heapSort(this.arr);
    }

    private void heapSort(int[] arr){
        //0. 边界条件
        if (arr.length <= 1) {
            return;
        }
        //1.建堆
        buildHeap(arr);
        //2.排序,(上浮操作)
        int k = arr.length -1 ;
        while (k > 0) {
            int temp = arr[k];
            arr[k] = arr[0];
            arr[0] = temp;
            heapify(arr,0 , --k);
        }
    }

    private void heapify(int[] arr, int i, int heapLength) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if (left < heapLength && arr[left] < arr[i]) {
            smallest = left;
        }
        if (right < heapLength && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
            heapify(arr, smallest, heapLength);
        }
    }

    private void buildHeap(int[] arr) {
        int startIndex = arr.length / 2;
        for (int i = startIndex; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    public boolean push(int number){

    }

    public int pop (){

    }
}
