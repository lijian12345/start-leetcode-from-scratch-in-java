class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int temp = prices[i + 1] - prices[i];
            if (temp > 0) {
                max += temp;
            }
        }
        return max;
    }
}