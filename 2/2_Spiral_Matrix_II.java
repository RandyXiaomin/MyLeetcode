public class Solution {
    public int[][] generateMatrix(int n) {
        assert(n >= 0);
        int[][] res = new int[n][n];
        for (int i = 1, x = 0, y = 0, dir = 0; i <= n * n; i++) {
            res[x][y] = i;
            if (dir % 4 == 0) {
                if (y <= n - 2 - dir / 4) {
                    y++;
                } else {
                    x++;
                    dir++;
                }
            } else if (dir % 4 == 1) {
                if (x <= n - 2 - dir / 4) {
                    x++;
                } else {
                    y--;
                    dir++;
                }
                
            } else if (dir % 4 == 2) {
                if (y >= dir / 4 + 1) {
                    y--;
                } else {
                    x--;
                    dir++;
                }
            } else {
                if (x >= dir / 4 + 2) {
                    x--;
                } else {
                    y++;
                    dir++;
                }
            }
        }
        return res;
    }
}