class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        Set<Integer> sortedNum=new TreeSet<Integer>();
        for(int num:nums){
            sortedNum.add(num);
        }
        int max=0, curMax=0, prev=0;
        for(int num: sortedNum){
            if(num-prev==1){
                curMax++;
            }else{
                curMax=1;
            }
            prev=num;
            if(curMax>max){
                max=curMax;
            }
        }
        
        return max;
    }
}