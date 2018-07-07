class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        
        int k = 2;
        int[] buy = new int[k]; // cost for making i'th buy , negative
        int[] sell = new int[k]; // cost for maksing i'th sell cost, at lease 0
        
        // init
        for (int i = 0; i < k; i++) {
            buy[i] = Integer.MIN_VALUE;
            sell[i] = 0;
        }
        
        // state
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                
                
                if (j == 0)
                    buy[j] = Math.max(buy[j], -1 * prices[i]);
                else 
                    buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
            
            // buy[0] = Math.max(buy[0], -1 * prices[i]);
            // sell[0] = Math.max(sell[0], buy[0] + prices[j]);
            // buy[1] = Math.max(buy[1], sell[0] - prices[i]);
            // sell[1] = Math.max(sell[1], buy[1] + prices[j]);            
        }
        
        return sell[k - 1];
    }
}