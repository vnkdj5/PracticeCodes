class Solution {
    //DP Memorization approch
    public int jump_dp(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp, 100001);
        return calculate(nums, dp, 0);
    }
    
    public int calculate(int nums[], int dp[], int pos){
        if(pos>=nums.length-1)
            return 0; //No need to jump as we reached our goal;
        if(dp[pos]!=100001) return dp[pos];
        
        for(int i=1;i<=nums[pos];i++){
            dp[pos]=Math.min(dp[pos], 1+calculate(nums,dp, i+pos));
        }
        return dp[pos];
    }
    
    public int jump(int[] nums) {
        int jumps=0, maxJump=0,curMax=0;
        int i=0;
        while(curMax<nums.length-1){
            maxJump=Math.max(maxJump, i+nums[i]);
            
            if(i==curMax){
                curMax=maxJump;
                jumps++;
            }
            i++;
        }
        return jumps;
    }
}

/*
We can iterate over all indices maintaining the furthest reachable position from current index - maxReachable and currently furthest reached position - lastJumpedPos. Everytime we will try to update lastJumpedPos to furthest possible reachable index - maxReachable.

Updating the lastJumpedPos separately from maxReachable allows us to maintain track of minimum jumps required. Each time lastJumpedPos is updated, jumps will also be updated and store the minimum jumps required to reach lastJumpedPos (On the contrary, updating jumps with maxReachable won't give the optimal (minimum possible) value of jumps required).

We will just return it as soon as lastJumpedPos reaches(or exceeds) last index.

We can try to understand the steps in code below as analogous to those in BFS as -

maxReachable = max(maxReachable, i + nums[i]) : Updating the range of next level. Similar to queue.push(node) step of BFS but here we are only greedily storing the max reachable index on next level.

i == lastJumpedPos : When it becomes true, current level iteration has been completed.

lastJumpedPos = maxReachable : Set range till which we need to iterate the next level

jumps++ : Move on to the next level.

return jumps : The final answer will be number of levels in BFS traversal.


*/
