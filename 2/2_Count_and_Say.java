public class Solution {
    public String countAndSay(int n) {
        return countAndSay(n - 1, "1");
    }
    
    public String countAndSay(int n, String str) {
        if (n == 0) {
            return str;
        }
        StringBuilder ret = new StringBuilder();
        char pre = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == pre) {
                count++;
            } else {
                ret.append(count).append(pre);
                pre = str.charAt(i);
                count = 1;
            }
        }
        return countAndSay(n - 1, ret.append(count).append(pre).toString());
    }
}