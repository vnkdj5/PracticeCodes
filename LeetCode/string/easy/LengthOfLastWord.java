class Solution {
    public int lengthOfLastWord(String s) {
        int length=0;
        if(s==null || s.isEmpty())
            return length;
     
        int n=s.length()-1;
        while(n>=0 && s.charAt(n)==' ')
            n--;
        
        for(int i=n;i>=0;i--){
            if(s.charAt(i)==' ')
                break;
            length++;
        }
        
        return length;
    }
}
