package problems;

/**
 * @description: 回文子串
 * @author: Sun, YaSong
 * @time: 2020/8/19 17:08
 */
public class Num647 {
    /**
     * 穷举法，列出所有可能的字符串，依次判断是否为回文子串
     * @param s
     * @return
     */
    public int countSubstrings(String s){
        int count = 0;
        if (s.length() <= 1) {
            return 1;
        }
        for (int i = 0; i < s.length(); i++) {
            int num = i + 1;
            for (int j = 0; j < s.length() - num + 1; j++) {
                int begin = j;
                int end = j + num;
                String subs = s.substring(begin, end);
                if (isBaskNum(subs)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public boolean isBaskNum(String subs) {
        if (subs.length() % 2 == 0){
            String beginStirng = subs.substring(0, subs.length() / 2);
            String endStirng = subs.substring(subs.length() / 2);
            if (new StringBuffer(beginStirng).reverse().toString().equals(endStirng)){
                return true;
            }else{
                return false;
            }
        }
        else{
            String beginStirng = subs.substring(0, subs.length() / 2);
            String endStirng = subs.substring((subs.length() / 2) + 1, subs.length());
            if (new StringBuffer(beginStirng).reverse().toString().equals(endStirng)){
                return true;
            }else{
                return false;
            }
        }

    }

    public static void main(String[] args) {
        Num647 num647 = new Num647();
        int count = num647.countSubstrings("aaa");
        System.out.println(count);
    }
}
