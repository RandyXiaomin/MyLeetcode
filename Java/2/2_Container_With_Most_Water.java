public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int ret = 0;
        for (int left = 0, right = height.length - 1; left < right;) {
            ret = Math.max(ret, (right - left) * Math.min(height[right], height[left]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return ret;
    }
}