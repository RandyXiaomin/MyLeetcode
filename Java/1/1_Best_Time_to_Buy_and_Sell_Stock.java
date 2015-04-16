public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int ret = 0;
        for (int min = prices[0], i = 1; i < prices.length; i++) {
            ret = Math.max(ret, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return ret;
    }
}