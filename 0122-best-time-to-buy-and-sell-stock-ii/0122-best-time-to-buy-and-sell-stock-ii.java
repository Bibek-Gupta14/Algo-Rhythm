class Solution {
    public int maxProfit(int[] prices) {
        int initial = prices[0];
        int profit = 0;
        
        if(prices.length < 2) {
            return profit;
        }

        for(int i=1; i<prices.length; i++) {
            if(prices[i] > initial) {
                profit += (prices[i] - initial);
                initial = prices[i];
            }
            initial = prices[i];
        }
        return profit;
    }
}