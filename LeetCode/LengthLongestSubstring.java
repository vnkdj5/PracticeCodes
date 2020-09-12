import java.util.*;
class Solution {
    //https://leetcode.com/problems/longest-substring-without-repeating-characters
   
    
    public int lengthOfLongestSubstring(String s) {
        int length=0;
        int i=0;//Will store starting index
        int []lastIndex=new int[256];
        Arrays.fill(lastIndex, -1);
        
        //j will always store last index
        for(int j=0; j<s.length();j++){
            
            i = Math.max(i, lastIndex[s.charAt(j)]+1); //Starting of window
            
            length = Math.max(length, j-i+1); //largest substring
            
            lastIndex[s.charAt(j)] = j; //update the last index of char[j]
        }
        
        
        return length;
    }
}

/*
//o^2 solution
public int lengthOfLongestSubstring(String s) {
        int length=0;
        
        for(int i=0;i<s.length();i++){
            Set<Character> visited=new HashSet<>();
            for(int j=i; j<s.length();j++){
              
                if(visited.contains(s.charAt(j)))
                    break;
                else{
                    visited.add(s.charAt(j));
                    length=Math.max(length, j-i+1);
                }
            }
        }
        
        return length;
    }
*/
