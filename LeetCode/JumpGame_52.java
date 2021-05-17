class Solution {
  //https://leetcode.com/problems/jump-game/
     public boolean canJump(int[] nums) {
        int max=0;
        int len=nums.length;
        for(int i=0;i<=max;i++){
            max=Math.max(max, i+nums[i]);
            if(max>=nums.length-1)
                return true;
        }
         return false;
    }
    
    
    
    
    //Greedy approch2
    public boolean canJump2(int[] nums) {
        int lastGood=nums.length-1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]+i>=lastGood){
                lastGood=i;
            }
                
        }
        return lastGood==0;
    }
}
