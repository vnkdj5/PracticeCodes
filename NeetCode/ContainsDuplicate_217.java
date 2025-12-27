class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniqueNums=new HashSet<>();
        
        for(int num:nums){
            if(uniqueNums.contains(num))
                return true;
            else
                uniqueNums.add(num);
        }
        return false;
    }
  
  
  /*
  class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (final int num : nums) {
            if (!uniques.add(num)) {
                return true;
            }
        }
        return false;
    }
}
  
  
  */
