public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length <= 2) {
            return A == null ? 0 : A.length;
        }
        int ret = A.length;
        for (int i = 1, pointer = 1, last = A[0], count = 1; i < A.length; i++) {
            if (last == A[i]) {
                if (count != 2) {
                    count++;
                    A[pointer++] = A[i];
                } else {
                    ret--;
                }
            } else {
                last = A[i];
                count = 1;
                A[pointer++] = A[i];
            }
        }
        return ret;
    }
}