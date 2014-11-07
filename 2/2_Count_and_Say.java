public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        return helper(n, "1");
    }
    
    public String helper(int n, String s) {
        if (n == 1) {
            return s;
        }
        int count = 1;
        char last = s.charAt(0);
        String res = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == last) {
                count++;
            } else {
                res += count;
                res += last;
                last = s.charAt(i);
                count = 1;
            }
        }
        res += count;
        res += last;
        return helper(n - 1, res);
    }
}