public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        boolean[][] rowFlag = new boolean[9][9];
        boolean[][] colFlag = new boolean[9][9];
        boolean[][] bloFlag = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int c = board[i][j] - '1';
                    if (rowFlag[i][c] || colFlag[j][c] || bloFlag[i / 3 * 3 + j / 3][c]) {
                        return false;
                    }
                    rowFlag[i][c] = true;
                    colFlag[j][c] = true;
                    bloFlag[i / 3 * 3 + j / 3][c] = true;
                }
            }
        }
        return true;
    }
}