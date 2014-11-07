public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0 || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] flags = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (valid(flags, board, word, 0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean valid(boolean[][] flags, char[][] board, String word, int index, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || flags[row][col] || word.charAt(index) != board[row][col]) {
            return false;
        }
        if (index++ == word.length() - 1) {
            return true;
        }
        flags[row][col] = true;
        if (valid(flags, board, word, index, row, col - 1) || valid(flags, board, word, index, row, col + 1) || valid(flags, board, word, index, row + 1, col) || valid(flags, board, word, index, row - 1, col)) {
            return true;
        }
        flags[row][col] = false;
        return false;
    }
}