class Solution {
//https://www.youtube.com/watch?v=AyiGBwFlMb8
        public boolean containsNearbyDuplicate(int[] nums, int k) {
                int n=nums.length;
                //Set maintains window size;
                Set<Integer> window=new HashSet<>();
                int i=0;
                for(int j=0;j<n;j++){
                    //Case when window is expanded beyond k, shrink the window
                    if(j-i>k){
                        window.remove(nums[i++]);
                    }
                    //add element to window, check if its duplicate or not
                    if(!window.add(nums[j])){
                        return true;
                    }
                }
            return false;

        }
    public boolean containsNearbyDuplicateMap(int[] nums, int k) {

        //<Num,Index> Map
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer cur=map.get(nums[i]);
            if(cur!=null && i-cur<=k){
                return true;
            }
            map.put(nums[i], i);

        }
        return false;
        
    }
}
