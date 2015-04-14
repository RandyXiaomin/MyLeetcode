public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        int res = 1;
        for (int i = 0, index = 0, newIndex = 0; i < A.length; i++) {
            if (i > index + A[index]) {
                index = newIndex;
                newIndex = i;
                res++;
            }
            newIndex = i + A[i] >= newIndex + A[newIndex] ? i : newIndex;
        }
        return res;
    }
}