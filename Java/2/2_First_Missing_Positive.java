public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= A.length && A[i] >= 1 && A[i] != i + 1 && A[A[i] - 1] != A[i]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i--] = temp;
            }
        }
        int ret = 1;
        while (ret <= A.length && A[ret - 1] == ret) {
            ret++;
        }
        return ret;
    }
}