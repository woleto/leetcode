package algorithm;

import java.util.Stack;
import com.sun.javadoc
/**
 * @description:
 * @author: Sun, YaSong
 * @time: 2020/8/27 9:13
 */
public class FullPrem {
    Stack<Integer> stack = new Stack<>();
    public static void perm(int[] arr, Stack<Integer> stack) {
        if (arr.length <= 0) {
            System.out.println(stack);
        }
        else{
            for (int i = 0; i < arr.length; i++) {
                stack.push(arr[i]);
//                自己的写的有错误 2020-8-27 17:05:50
//                int[] tempArray = new int[arr.length - 1 - i];
//                System.arraycopy(arr, i + 1, tempArray, 0, arr.length - 1 - i);

//                别人写的正确的
                int[] tempArray = new int[arr.length - 1];
                System.arraycopy(arr,0,tempArray,0,i);
                System.arraycopy(arr,i + 1,tempArray, i,arr.length - i - 1);

                perm(tempArray, stack);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        perm(new int[]{1, 2, 3}, new Stack<Integer>());
    }
}
