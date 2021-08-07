class Solution {
    
    //2 pointers
    public int[] twoSum(int[] numbers, int target) {
        int result[]=new int[2];
        if(numbers==null || numbers.length<2)
            return result;
        int low=0;
        int high=numbers.length-1;
        while(low<high){
            int sum=numbers[low]+numbers[high];
            if(sum>target){
               high--;
            }else if(sum<target){
                low++;
            }else{
                result[0]=low+1;
                result[1]=high+1;
                break;
               //  return new int[]{low+1, high+1};
            }
        }
        return result;
        
    }
//====================================================================    
    //Binary Search
    public int[] twoSum_BinarySearch(int[] numbers, int target) {
        int result[]=new int[2];
        for(int i=0;i<numbers.length-1;i++){
            int index=binarySearch(numbers, target-numbers[i], i+1);
            if(index!=-1 && index!=i){
                result[0]=i+1;
                result[1]=index+1;
                break;
            }
        }
        return result;
    }
    
    public int binarySearch(int a[], int num, int start){
        int end=a.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            
            if(a[mid]==num){
                return mid;
            }else if(a[mid]>num){
                end=mid-1;
            }else{
                start=mid+1;
            }
            
        }
        return -1;
    }
    
//====================================================================     
    public int[] twoSum_HashmapMethod(int[] numbers, int target) {
        HashMap<Integer, Integer> hs=new HashMap<>();
        for(int i=0;i<numbers.length; i++){
            hs.put(numbers[i], i);
        }
        
        for(int i=0;i<numbers.length;i++){
            int compliment=target-numbers[i];
            if(hs.get(compliment)!=null && hs.get(compliment)!=i ){
                return new int[]{i+1, hs.get(compliment)+1};
            }
        }
        
        return new int[2];
    }
}
