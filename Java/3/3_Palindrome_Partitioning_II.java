public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        boolean[][] flag = new boolean[s.length()][s.length()];
        int[] dp = new int[s.length()];
        for (int end = 1; end < s.length(); end++) {
            dp[end] = dp[end - 1] + 1;
            for (int start = end - 1; start >= 0; start--) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || flag[start + 1][end - 1])) {
                    flag[start][end] = true;
                    dp[end] = start != 0 ? Math.min(dp[end], dp[start - 1] + 1) : 0;
                }
            }
        }
        return dp[s.length() - 1];
    }
}