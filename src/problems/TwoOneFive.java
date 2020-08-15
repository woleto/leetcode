package problems;

/**
 * @author: woleto
 * @date: 2020/8/2 13:39
 * @Email: woleto@126.com
 * @Description: num215.数组中第K个最大的元素
 */
public class TwoOneFive {
    public int findKthLargest(int[] nums, int k) {
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
}
