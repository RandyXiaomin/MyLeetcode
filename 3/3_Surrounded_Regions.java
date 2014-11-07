public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '#';
                helper(i, 0, board);
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = '#';
                helper(i, n - 1, board);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = '#';
                helper(0, i, board);
            }
            if (board[m - 1][i] == 'O') {
                board[m - 1][i] = '#';
                helper(m - 1, i, board);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void helper(int i, int j, char[][] board) {
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{i, j});
        while (!q.isEmpty()) {
            Integer[] p = q.poll();
            int x = p[0];
            int y = p[1];
            if (x + 1 < board.length && board[x + 1][y] == 'O') {
                q.offer(new Integer[] {x + 1, y});
                board[x + 1][y] = '#';
            }
            if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
                q.offer(new Integer[] {x, y + 1});
                board[x][y + 1] = '#';
            }
            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                q.offer(new Integer[] {x - 1, y});
                board[x - 1][y] = '#';
            }
            if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                q.offer(new Integer[] {x, y - 1});
                board[x][y - 1] = '#';
            }
        }
    }
}