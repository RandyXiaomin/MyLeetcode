public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] rect = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rect[i][j] = matrix[i][j] == '0' ? 0 : (i == 0 ? 1 : rect[i - 1][j] + 1);
            }
        }
        int ret = 0;
        for (int i = 0; i < matrix.length; i++) {
            ret = Math.max(ret, maxRectangleHistgram(rect[i]));
        }
        return ret;
    }
    
    public int maxRectangleHistgram(int[] rect) {
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for (int i = 0; i < rect.length;) {
            if (stack.isEmpty() || rect[i] > rect[stack.peek()]) {
                stack.push(i++);
            } else {
                ret = Math.max(ret, rect[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return ret;
    }
}