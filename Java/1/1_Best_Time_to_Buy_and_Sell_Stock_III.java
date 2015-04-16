public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[] left = new int[n];
        for (int min = prices[0], i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        int[] right = new int[n];
        for (int max = prices[n - 1], i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, left[i] + right[i]);
        }
        return ret;
    }
}