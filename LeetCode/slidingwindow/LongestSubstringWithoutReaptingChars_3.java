class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty())
            return 0;
        
        int start=0, len=0;
        
      //Size can be most 256..declaring it will save time
        HashMap<Character,Integer> hs=new HashMap<>(256);
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(hs.containsKey(ch)){
                
                //update start to next index only if its large than current start
                start=Math.max(start, hs.get(ch)+1);
            }
            
            hs.put(ch, i);
            
            len=Math.max(len, i-start+1);
        }
        
        return len;
        
    }
}
