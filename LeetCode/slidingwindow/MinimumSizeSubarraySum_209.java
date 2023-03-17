class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int min=Integer.MAX_VALUE;
        int start=0;
        int sum=0;
        for(int end=0;end<nums.length;end++){
            sum=sum+nums[end];

            while(sum>=target){
                min=Math.min(min, end-start+1);
                sum=sum-nums[start++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
