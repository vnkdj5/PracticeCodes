class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        
        res[0]=1;
        
        //calculating lefts of i, for first num we considerdefault value=1
        for(int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        int right=1;
        for(int i=n-1;i>=0;i--){
            res[i]*=right;
            right*=nums[i];
        }
        
        /*
        Nums: 1, 2,    3,     4
        res : 1, 1*1=1,1*2=2, 4*2=6 
        right: 12*2,3*3=12,4,1
        right=1 at start
        res:24,12 8 6
        */
        
        return res;
        
    }
}
