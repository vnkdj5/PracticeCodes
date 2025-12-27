class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
       
        int i=0; //I will hold non-zero indexes
        for(int j=0;j<n;j++){
            if(nums[j]!=0){
                swap(nums, j, i);
                i++;
            }
        }
       
    }
    
     public void swap(int[] nums,int first,int second)
    {
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
    
     public void moveZeroes_BruteForce(int[] nums) {
        int countZeros=0;
        int n=nums.length;
       
        int i=0;
        for(int j=0;j<n;j++){
            if(nums[j]!=0){
                nums[i++]=nums[j];
            }else{
                countZeros++;
            }
        }
        
        if(countZeros==n)
            return;
        i=n-1;
        while(countZeros!=0){
            nums[i--]=0;
            countZeros--;
        }
    }
}
