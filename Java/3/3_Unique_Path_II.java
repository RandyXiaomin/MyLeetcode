public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] dp = new int[col];
        for (int c = 0; c < col; c++) {
            if (obstacleGrid[0][c] == 1) {
                dp[c] = 0;
                break;
            } else {
                dp[c] = 1;
            }
        }
        for (int r = 1; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[c] = 0;
                } else if (c != 0) {
                    dp[c] += dp[c - 1];
                }
            }
        }
        return dp[col - 1];
    }
}