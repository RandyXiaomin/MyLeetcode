public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int[] m = new int[A.length - 2];
        int max = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            m[i - 1] = max;
            max = Math.max(max, A[i]);
        }
        int res = 0;
        max = A[A.length - 1];
        for (int i = A.length - 2; i >= 1; i--) {
            if (A[i] < max && A[i] < m[i - 1]) {
                res += Math.min(max, m[i - 1]) - A[i];
            }
            max = Math.max(max, A[i]);
        }
        return res;
    }
}