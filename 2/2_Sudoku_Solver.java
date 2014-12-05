public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        boolean[][] rowFlag = new boolean[9][9];
        boolean[][] colFlag = new boolean[9][9];
        boolean[][] boxFlag = new boolean[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int n = board[row][col] - '1';
                    rowFlag[row][n] = true;
                    colFlag[col][n] = true;
                    boxFlag[3 * (row / 3) + col / 3][n] = true;
                }
            }
        }
        helper(0, 0, rowFlag, colFlag, boxFlag, board);
    }
    
    public boolean helper(int row, int col, boolean[][] rowFlag, boolean[][] colFlag, boolean[][] boxFlag, char[][] board) {
        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return helper(row + 1, 0, rowFlag, colFlag, boxFlag, board);
        }
        if (board[row][col] != '.') {
            return helper(row, col + 1, rowFlag, colFlag, boxFlag, board);
        }
        boolean isSolved = false;
        for (int n = 0; n < 9 && !isSolved; n++) {
            if (!rowFlag[row][n] && !colFlag[col][n] && !boxFlag[3 * (row / 3) + col / 3][n]) {
                board[row][col] = (char) (n + '1');
                rowFlag[row][n] = true;
                colFlag[col][n] = true;
                boxFlag[3 * (row / 3) + col / 3][n] = true;
                isSolved = helper(row, col + 1, rowFlag, colFlag, boxFlag, board);
                if (!isSolved) {
                    board[row][col] = '.';
                    rowFlag[row][n] = false;
                    colFlag[col][n] = false;
                    boxFlag[3 * (row / 3) + col / 3][n] = false;
                }
            }
        }
        return isSolved;
    }
}