public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        int[] leftMax = new int[A.length - 2];
        for (int i = 1, max = A[0]; i < A.length - 1; i++) {
            leftMax[i - 1] = max;
            max = A[i] > max ? A[i] : max;
        }
        int ret = 0;
        for (int i = A.length - 2, rightMax = A[A.length - 1]; i >= 1; i--) {
            ret += Math.min(rightMax, leftMax[i - 1]) > A[i] ? Math.min(rightMax, leftMax[i - 1]) - A[i] : 0;
            rightMax = A[i] > rightMax ? A[i] : rightMax;
        }
        return ret;
    }
}