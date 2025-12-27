class Solution {
    
/*
While looping find the minimum value and max profit between min and curreny iteration. 
If we plot this as graph, we will first finf the mininum value with following max Profit(sell price which generates max profit)

*/
    public int maxProfit(int[] prices) {
        int buyPrice=Integer.MAX_VALUE;
        int curProfit=0, maxProfit=0;
        for(int i=0;i<prices.length;i++){
            
            if(prices[i]<buyPrice){
                buyPrice=prices[i];
                continue;
            }
            curProfit=prices[i]-buyPrice;
            maxProfit=Math.max(curProfit, maxProfit);
        }
        return maxProfit;

    }
}
