public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (r == 0) {
                    dp[c] = (c > 0 ? dp[c - 1] : 0) + grid[r][c];
                } else {
                    dp[c] = (c > 0 ? Math.min(dp[c - 1], dp[c]) : dp[c]) + grid[r][c];
                }
            }
        }
        return dp[col - 1];
    }
}