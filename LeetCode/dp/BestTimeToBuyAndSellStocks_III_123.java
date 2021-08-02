class Solution {
    public int maxProfit(int[] prices) {
        int buy1=Integer.MAX_VALUE, buy2=Integer.MAX_VALUE;
        int sell1=0, sell2=0;
        
        for(int i=0;i<prices.length;i++){
            buy1=Math.min(buy1, prices[i]);
            sell1=Math.max(sell1, prices[i]-buy1);
            
            buy2=Math.min(buy2, prices[i]-sell1);
            sell2=Math.max(sell2, prices[i]-buy2);
        }
        return sell2;
    }
    
    /*
    We can also explain the above codes in other words. On every day, we buy the share with the price as low as we can, and sell the share 
    with price as high as we can. For the second transaction, we integrate the profit of first transaction into the cost of the second buy, 
    then the profit of the second sell will be the total profit of two transactions.
    
    */
}
