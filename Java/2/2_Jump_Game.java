public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        for (int i = 0, last = 0; i < A.length - 1; i++) {
            if (last + A[i] == 0) {
                return false;
            } else {
                last = Math.max(last, A[i]) - 1;
            }
        }
        return true;
    }
}