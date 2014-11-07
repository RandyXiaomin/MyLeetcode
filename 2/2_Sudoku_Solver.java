public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        boolean[][] rowFlag = new boolean[9][9];
        boolean[][] colFlag = new boolean[9][9];
        boolean[][] bloFlag = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '1';
                    rowFlag[i][n] = true;
                    colFlag[j][n] = true;
                    bloFlag[i / 3 * 3 + j / 3][n] = true;
                }
            }
        }
        helper(0, 0, board, rowFlag, colFlag, bloFlag);
    }
    
    public boolean helper(int x, int y, char[][] board, boolean[][] rowFlag, boolean[][] colFlag, boolean[][] bloFlag) {
        if (x == 9) {
            return true;
        }
        if (board[x][y] == '.') {
             for (char c = '1'; c <= '9'; c++) {
                if (!rowFlag[x][c - '1'] && !colFlag[y][c - '1'] && !bloFlag[x / 3 * 3 + y / 3][c - '1']) {
                    rowFlag[x][c - '1'] = true;
                    colFlag[y][c - '1'] = true;
                    bloFlag[x / 3 * 3 + y / 3][c - '1'] = true;
                    board[x][y] = c;
                    boolean solved = false;
                     if (y < 8) {
                        solved = helper(x, y + 1, board, rowFlag, colFlag, bloFlag);
                    } else {
                        solved = helper(x + 1, 0, board, rowFlag, colFlag, bloFlag);
                    }
                    if (!solved) {
                        rowFlag[x][c - '1'] = false;
                        colFlag[y][c - '1'] = false;
                        bloFlag[x / 3 * 3 + y / 3][c - '1'] = false;
                        board[x][y] = '.';
                    } else {
                        return true;
                    }
                }
            }
            return false;
        } else  if (y < 8) {
            return helper(x, y + 1, board, rowFlag, colFlag, bloFlag);
        } else {
            return helper(x + 1, 0, board, rowFlag, colFlag, bloFlag);
        }
    }
}