package problems;

import java.util.*;

/**
 * @description:
 * @author: Sun, YaSong
 * @time: 2020/8/4 14:08
 */
public class Num632 {

    public int[] smallestRange(List<List<Integer>> nums) {
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        int minRange = rangeRight - rangeLeft;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] next = new int[size];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer index1, Integer index2) {
                return nums.get(index1).get(next[index1]) - nums.get(index2).get(next[index2]);
            }
        });
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            int minIndex = priorityQueue.poll();
             int curRange = max - nums.get(minIndex).get(next[minIndex]);
            if (curRange < minRange) {
                minRange = curRange;
                rangeLeft = nums.get(minIndex).get(next[minIndex]);
                rangeRight = max;
            }
            next[minIndex]++;
            if (next[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            priorityQueue.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }
        return new int[]{rangeLeft, rangeRight};
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        List<Integer> num1 = new ArrayList<Integer>(Arrays.asList(4,10,15,24,26));
        List<Integer> num2 = new ArrayList<Integer>(Arrays.asList(0,9,12,20));
        List<Integer> num3= new ArrayList<Integer>(Arrays.asList(5,18,22,30));
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        Num632 sixThreeTwo = new Num632();
        int[] result = sixThreeTwo.smallestRange(nums);
        System.out.println(result[0] + "-" + result[1]);
    }
}
