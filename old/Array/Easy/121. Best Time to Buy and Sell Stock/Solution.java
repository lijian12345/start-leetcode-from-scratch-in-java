class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int temp = 0, maxp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else
                temp = prices[i] - min;
            if (temp > maxp)
                maxp = temp;
        }
        return maxp;
    }
}