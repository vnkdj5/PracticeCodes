class Solution {
    
/*
While looping find the minimum value and max profit between min and curreny iteration. 
If we plot this as graph, we will first finf the mininum value with following max Profit(sell price which generates max profit)

*/
    public int maxProfit(int[] prices) {
        int minBuyPrice=Integer.MAX_VALUE;
        int profit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minBuyPrice){
                minBuyPrice=prices[i];
            }
            if(prices[i]-minBuyPrice>profit)
                profit=prices[i]-minBuyPrice;
        }
        return profit;
    }
}
