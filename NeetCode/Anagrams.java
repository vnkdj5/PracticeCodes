//Use Hashmap for unicode:https://leetcode.com/problems/valid-anagram/discuss/1740513/JAVA-3-Easy-Solutions-HashMap-Sorting-Arrays


class Solution {
      
    
     public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length())
            return false;
        
        char arr1[]=s.toCharArray();
        char arr2[]=t.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i])
                return false;
        }
        return true;        
        
    }
    
    
     public boolean isAnagram1(String s, String t) {
        
        if(s.length()!=t.length())
            return false;
        
        int counts[]=new int[26];
        

        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)-'a']++;
            counts[t.charAt(i)-'a']--;
        }
        
        for(int count:counts){
            if(count!=0)
                return false;
        }
        return true;        
        
    }
    
}
