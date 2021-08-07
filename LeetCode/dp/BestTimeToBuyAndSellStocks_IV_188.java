class Solution {
    /*
    Idea is simple : Keep track of the minimum value till previous day and 
check how much maximum profit can be obtained for current day.

//Generalized solution. Can be used to solve 3rd problem
    
    */
    
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        
        int dp[][]=new int[k+1][prices.length];
        for(int i=1; i<=k;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j<prices.length;j++){
                min=Math.min(min, prices[j-1]-dp[i-1][j-1]);
                dp[i][j]=Math.max(dp[i][j-1], prices[j]-min);
            }
        }
        
        return dp[k][prices.length-1];
    }
}
