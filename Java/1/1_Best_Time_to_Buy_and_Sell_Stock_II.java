public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            ret += prices[i - 1] < prices[i] ? prices[i] - prices[i - 1] : 0;
        }
        return ret;
    }
}