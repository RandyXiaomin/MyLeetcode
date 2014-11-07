public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null) {
            return 0;
        }
        if (A.length <= 1) {
            return A.length;
        }
        int length = A.length;
        for (int i = 1, last = A[0], crt = 1; i < A.length; i++) {
            if (A[i] != last) {
                A[crt] = A[i];
                last = A[crt++];
            } else {
                length--;
            }
        }
        return length;
    }
}