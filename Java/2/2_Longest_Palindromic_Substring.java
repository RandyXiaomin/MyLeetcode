public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        boolean[][] flag = new boolean[s.length()][s.length()];
        String ret = "";
        for (int end = 1; end < s.length(); end++) {
            for (int start = end - 1; start >= 0; start--) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || flag[start + 1][end - 1])) {
                    flag[start][end] = true;
                    ret = end - start + 1 > ret.length() ? s.substring(start, end + 1) : ret;
                }
            }
        }
        return ret;
    }
}