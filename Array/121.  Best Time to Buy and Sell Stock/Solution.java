class Solution {
    public int maxProfit(int[] prices) {
        int curmin = prices[0];
        int profit = 0;
        for (int i=1;i<prices.length;i++) {
            curmin = Math.min(curmin,prices[i]);
            profit = Math.max(profit,prices[i]-curmin);
        }
        return profit;
    }
}
