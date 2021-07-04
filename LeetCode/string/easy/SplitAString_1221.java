class Solution {
    //Logic: increse count when there is L, otherwise decrease it
    //When it reaches 0, then we got our one combination
  
  /*
  Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
  
  */
    public int balancedStringSplit(String s) {
        int count=0;
        int combinations=0;
        if(s==null)
            return 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L')
                count++;
            
            if(s.charAt(i)=='R')
                count--;
            
            if(count==0)
                combinations++;
        }
        
        return combinations;
    }
}
