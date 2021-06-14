class Solution {
  //FIBOnacci fseries
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        
        int first=1, second=2;
        for(int i=2;i<n;i++){
            int third=first+second;
            first=second;
            second=third;
        }
        return second;
        
    }
    
    
    //DP solution
    public int climbStairs_dp(int n) {
        
        if(n==1)
            return 1;
        int []memo=new int[n]; //n+1 to handle the base base n=1
        
        memo[0]=1;
        memo[1]=2;
        for(int i=2;i<n;i++){
            memo[i]=memo[i-1]+memo[i-2];
        }
        return memo[n-1];
        
    }
    
  /* Recursion brute force
  
  
   public int climbStairs(int n) {
        
        int []memo=new int[n];
        return climbWays(0,n, memo);
        
    }
  private int climbWays(int i, int n){
        if(i>n)
            return 0;
        
        if(i==n)
            return 1;
        
        return climbWays(i+1, n) +climbWays(i+2,n);
    } 
    
    //Recursion with memorization
    private int climbWays(int i, int n, int memo[]){
        
        if(i>n) return 0;
        if(i==n) return 1;
        
        if(memo[i]>0)return memo[i];
        
        memo[i]= climbWays(i+1, n, memo)+climbWays(i+2, n,memo);
        return memo[i];
    }
    
    */
}
