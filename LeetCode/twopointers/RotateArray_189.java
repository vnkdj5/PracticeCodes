class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        //1. Reverse all array
        reverse(nums, 0, n-1);
        //2. Reverse First k elements (i.e. Right shifted from the end to start)
        reverse(nums,0, k-1);
        //3. Reverse the k to n-1 elements (i.e. The elements that were initially at start)
        reverse(nums, k, n-1);
        
    }
    
    private void reverse(int[] nums, int i, int j){
        
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    
    
    
    public void rotate_ExtraSpace(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        int arr[]=new int[k];
        int j=0;
        for(int i=n-k;i<n;i++){
            arr[j++]=nums[i];
        }
        
        for(int i=n-1;i>=k;i--){
            
            nums[i]=nums[i-k];
        }
        
        for(int i=0;i<k;i++){
            nums[i]=arr[i];
        }
        
    }
}
