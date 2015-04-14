public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0; 
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == A[mid]) {
                return mid;
            } else if (target < A[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}