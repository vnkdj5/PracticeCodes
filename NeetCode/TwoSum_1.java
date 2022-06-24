class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        
        for(int i=0;i<nums.length;i++){
            int compliment=target-nums[i];
            Integer value=map.get(compliment);
            if(value!=null && value!=i){
                return new int[]{i, value};
            }
        }
        
        return null;
    }
}
