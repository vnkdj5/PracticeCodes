class Solution {
    
    public int removeDuplicates(int[] nums) {
    if(nums==null ||nums.length==0)
            return 0;
    int index=0;
    for(int j=1;j<nums.length;j++){
        if(nums[j]!=nums[index]){
            index++;
            nums[index]=nums[j];
        }
    }
        return index+1;
    }
    
    public int removeDuplicates1(int[] nums) {
        if(nums==null ||nums.length==0)
            return 0;
        final int MAX=999999;
        int temp=MAX;
        for(int i=0;i<nums.length;i++){
            if(temp==nums[i])
                nums[i]=MAX;
            else
                temp=nums[i];
        }
        
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=MAX)
                nums[count++]=nums[i];
        }
        return count;
    }
}
