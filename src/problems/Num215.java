package problems;

/**
 * @author: woleto
 * @date: 2020/8/2 13:39
 * @Email: woleto@126.com
 * @Description: num215.数组中第K个最大的元素
 */
public class Num215 {
    /**
     * 冒泡排序方法解决问题
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestByBubbleSort(int[] nums, int k) {
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j > -1; j--) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            if (count++ > k)
                break;
        }
        return nums[nums.length - k];
    }

    /**
     * 堆排序
     * @param nums
     * @param k
     * @return
     */
    public int[] findKthLargestByHeapSort(int[] nums, int k){
        // 边界值验证
        if (nums.length <= 1) {
            return nums;
        }
        // 构建大根堆
        int start = nums.length / 2;
        for (int i = start; i >= 0; i--) {
            heapify(nums, start, nums.length);
        }

    }

    private void heapify(int[] nums, int start, int length) {

    }
}
