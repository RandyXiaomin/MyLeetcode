public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        for (int left = 0, right = A.length - 1; left <= right;) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if ((A[mid] >= A[left] && (target > A[mid] || target < A[left])) || (A[right] > A[mid] && target > A[mid] && target <= A[right])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}