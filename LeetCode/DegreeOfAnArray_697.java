import java.util.HashMap;

class Solution {
    //https://leetcode.com/problems/degree-of-an-array/
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>(); //count
        HashMap<Integer, Integer> first = new HashMap<>(); //First occurance
        int degree=0, res=0;
        for(int i=0; i<nums.length;i++){
            first.putIfAbsent(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
            
            
            if(count.get(nums[i])>degree){//Single Number with highest degree
                degree=count.get(nums[i]);
                res=i-first.get(nums[i])+1;
            }else if(count.get(nums[i])==degree)//With same degree many numbers exist
            {
                res=Math.min(res, i-first.get(nums[i])+1);
            }
        }
        return res;
        
    }
    
}
