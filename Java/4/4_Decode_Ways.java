public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[] {1, 1};
        for (int i = 1; i < s.length(); i++) {
            int n = Integer.parseInt(s.substring(i - 1, i + 1));
            if (s.charAt(i) == '0' && !(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')) {
                return 0;
            } else if (n == 10 || n == 20) {
                ;
            } else if (n >= 11 && n <= 26) {
                dp[i % 2] += dp[(i + 1) % 2];
            } else {
                dp[i % 2] = dp[(i + 1) % 2];
            }
        }
        return dp[(s.length() - 1) % 2];
    }
}