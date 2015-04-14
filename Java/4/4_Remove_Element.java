public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int end = A.length - 1;
        for (int i = 0; i <= end; i++) {
            if (A[i] == elem) {
                A[i--] = A[end--];
            }
        }
        return end + 1;
    }
}