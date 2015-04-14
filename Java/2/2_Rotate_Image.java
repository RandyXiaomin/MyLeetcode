public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length != matrix.length) {
            return;
        }
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            for (int start = layer, i = start, end = matrix.length - layer - 1; i < end; i++) {
                int top = matrix[start][i];
                int offset = i - start;
                matrix[start][i] = matrix[end - offset][start];
                matrix[end - offset][start] = matrix[end][end - offset];
                matrix[end][end - offset] = matrix[start + offset][end];
                matrix[start + offset][end] = top;
            }
        }
    }
}