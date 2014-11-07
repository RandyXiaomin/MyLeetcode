public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int min = Math.min(m, n);
        int max = Math.max(m, n);
        int[] dp = new int[min];
        Arrays.fill(dp, 1);
        for (int i = 1; i < max; i++) {
            for (int j = 1; j < min; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[min - 1];
    }
}