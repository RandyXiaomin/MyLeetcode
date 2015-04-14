public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }
        for (int left = 0, right = A.length - 1, i = 0; i <= right; i++) {
            if (A[i] == 0) {
                A[i] = i > left ? 1 : 0;
                A[left++] = 0;
            } else if (A[i] == 2) {
                swap(right--, i--, A);
            }
        }
    }
    
    public void swap(int a, int b, int[] A) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}