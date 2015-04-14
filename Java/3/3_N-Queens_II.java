public class Solution {
    private int res = 0;
    
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] state = new int[n];
        helper(0, state);
        return res;
    }
    public void helper(int row, int[] state) {
        if (row == state.length) {
            res++;
        }
        for (int i = 0; i < state.length; i++) {
            if (isValid(row, i, state)) {
                state[row] = i;
                helper(row + 1, state);
            }
        }
    }
    
    public boolean isValid(int row, int col, int[] state) {
        for (int i = 0; i < row; i++) {
            if (state[i] == col || Math.abs(i - row) == Math.abs(state[i] - col)) {
                return false;
            }
        }
        return true;
    }
}