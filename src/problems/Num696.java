package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 计数二进制子串
 * @author: Sun, YaSong
 * @time: 2020/8/10 17:00
 */
public class Num696 {

    public static int countBinarySubstrings(String s) {
//        得到连续的每个0或1个数
        List<Integer> counts = new ArrayList<Integer>();
        char beginNumber = s.charAt(0);
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (beginNumber == currentChar) {
                num++;
            }
            else{
                counts.add(num);
                num = 1;
                beginNumber = currentChar;
            }
        }
        counts.add(num);

        int siz = 0;
        for (int i = 0; i < counts.size() - 1; i++) {
            int si = Math.min(counts.get(i), counts.get(i + 1));
            siz += si;
        }
        return siz;
    }

    public static void main(String[] args) {
        String s = "00110011";
        int result = countBinarySubstrings(s);
        System.out.println(result);
    }
}
