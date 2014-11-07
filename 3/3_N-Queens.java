public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        int[] flag = new int[n];
        char[][] sol = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(sol[i], '.');
        }
        helper(0, flag, sol, res);
        return res;
    }
    
    private void helper(int row, int[] flag, char[][] sol, List<String[]> res) {
        if (row == flag.length) {
            String[] temp = new String[flag.length];
            for (int i = 0; i < flag.length; i++) {
                temp[i] = new String(sol[i]);
            }
            res.add(temp);
        }
        for (int col = 0; col < flag.length; col++) {
            if (isValid(row, col, flag)) {
                flag[row] = col;
                sol[row][col] = 'Q';
                helper(row + 1, flag, sol, res);
                flag[row] = 0;
                sol[row][col] = '.';
            }
        }
    }
    
    private boolean isValid(int row, int col, int[] flag) {
        for (int i = 0; i < row; i++) {
            if (flag[i] == col || Math.abs(row - i) == Math.abs(col - flag[i])) {
                return false;
            }
        }
        return true;
    }
}