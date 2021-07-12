class Solution {
    public boolean validPalindrome(String s) {
        if(s==null)
            return false;
        int i=0, j=s.length()-1;
        boolean isSkipped=false;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                //Skipping at most 1 char..Which can be left one or right#greedy
               return isPalindrome(s, i+1, j)|| isPalindrome(s, i, j-1);
            }
          
        }
        return true;
    }
    
    //Helper function for finding is string palindrome with given indexes (inclusive)
    private boolean isPalindrome(String str, int i,int j){
        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;      
    }
}
