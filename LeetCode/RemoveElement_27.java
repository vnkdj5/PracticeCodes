class Solution {
    
      public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0)
            return 0;
          
          int i=0;
          for(int j=0;j<nums.length;j++){
              if(nums[j]!=val){
                  nums[i]=nums[j];
                  i++;
              }
          }
          return i;
          
      }
    
    public int removeElement1(int[] nums, int val) {
        if(nums==null || nums.length==0)
            return 0;
        int high=nums.length-1;
        int low=0;
        while(low<=high){
            if(nums[high]==val)
                high--;
            else if(nums[low]==val)
            {
                int temp=nums[low];
                nums[low]=nums[high];
                nums[high]=temp;
                low++;
            }else
                low++;
            
        }
        return low;
    }
}
