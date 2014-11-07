public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0, x = 0, y = 0, dir = 0; i < m * n; i++) {
            res.add(matrix[y][x]);
            if (dir % 4 == 0) {
                if (x <= n - dir / 4 - 2) {
                    x++;
                } else {
                    dir++;
                    y++;
                }
            } else if (dir % 4 == 1) {
                if (y <= m - dir / 4 - 2) {
                    y++;
                } else {
                    dir++;
                    x--;
                }
            } else if (dir % 4 == 2) {
                if (x >= dir / 4 + 1) {
                    x--;
                } else {
                    dir++;
                    y--;
                }
            } else {
                if (y >= dir / 4 + 2) {
                    y--;
                } else {
                    dir++;
                    x++;
                }
            }
        }
        return res;
    }
}