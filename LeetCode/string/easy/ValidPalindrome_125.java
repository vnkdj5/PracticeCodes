class Solution {
    public boolean isPalindrome(String s) {
        if(s==null)
            return false;
        int i=0, j=s.length()-1;
        while(i<j){
            while(!Character.isLetterOrDigit(s.charAt(i)) && i<j){
                i++;   
            }
            while(!Character.isLetterOrDigit(s.charAt(j)) && i<j){
                j--;   
            }
            if(i<j && Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
