public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        boolean[][] rowFlag = new boolean[9][9];
        boolean[][] colFlag = new boolean[9][9];
        boolean[][] boxFlag = new boolean[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int n = board[row][col] - '1';
                    if (rowFlag[row][n] || colFlag[col][n] || boxFlag[3 * (row / 3) + col / 3][n]) {
                        return false;
                    }
                    rowFlag[row][n] = true;
                    colFlag[col][n] = true;
                    boxFlag[3 * (row / 3) + col / 3][n] = true;
                }
            }
        }
        return true;
    }
}