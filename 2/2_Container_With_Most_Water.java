public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int max = 0;
        for (int start = 0 ,end = height.length - 1; start < end;) {
            max = Math.max((end - start) * Math.min(height[start], height[end]), max);
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return max;
    }
}