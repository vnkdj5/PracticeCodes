class Solution {
    public String longestPalindrome(String s) {
    
    if(s==null || s.length()<1)
        return "";
        
    int n=s.length();
    int maxLength=1;
    int start=0;
    int low, high;
    for(int i=1;i<n;i++){
        //EVEN LENGTH PALINDROME center points as i-1 and i
        low=i-1;
        high=i;
        while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
            if((high-low+1)>maxLength){
                maxLength=high-low+1;
                start=low;
            }
            low--;
            high++;
        }
        
        //Odd length palindrome center points as i
        low=i-1;
        high=i+1;
        while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
            if((high-low+1)>maxLength){
                maxLength=high-low+1;
                start=low;
            }
            low--;
            high++;
        }
    
    }
    
    return s.substring(start, start+maxLength);       
    }
}
