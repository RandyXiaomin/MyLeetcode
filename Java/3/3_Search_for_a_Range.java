public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[] {-1, -1};
        }
        int l = -1;
        int r = -1;
        for (int left = 0, right = A.length - 1; left <= right;) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                l = mid;
                right = mid - 1;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        for (int left = 0, right = A.length - 1; left <= right;) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                r = mid;
                left = mid + 1;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[] {l, r};
    }
}