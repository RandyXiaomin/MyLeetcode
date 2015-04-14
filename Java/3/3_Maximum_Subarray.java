public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0];
        for (int i = 1, sum = A[0]; i < A.length; i++) {
            sum = Math.max(A[i], A[i] + sum);
            max = Math.max(sum, max);
        }
        return max;
    }
}