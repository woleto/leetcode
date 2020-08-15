package algorithm;

/**
 * @author: woleto
 * @date: 2020/8/15 13:27
 * @Email: woleto@126.com
 */
public class BubbleSort {
    /***
     * 默认从小到大进行冒泡排序
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public static int bubbleSort(int[] nums, int k){
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            if (count++ >= nums.length - k)
                break;
        }
        return nums[nums.length - k];
    }

    public static void main(String args[]){
        int[] nums = {3,2,3,1,2,4,5,6,5};
//        for (int elem:bubbleSort(nums)) {
//            System.out.print(elem + "-");
//        }
//        System.out.println();
        int result = bubbleSort(nums, 4);
        System.out.println(result);
    }
}
