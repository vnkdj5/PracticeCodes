class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        if(arr==null || arr.length<k){
            return count;
        }
        int i=0, curSum=0;
        
        for(int j=0;j<arr.length;j++){
            //calculate windows sum
            curSum+=arr[j];

            //till we reach window sum;
            if(j-i+1<k){
                continue;
            }
            
            //Given case
            if((curSum/k)>=threshold){
                count++;
            }

            //slide the window
            curSum-=arr[i++];
        }
        return count;
    }
}
