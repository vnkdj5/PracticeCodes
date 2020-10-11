class Solution {
    public boolean isPalindrome(int x) {
    //Negative Number case
        if (x < 0)
            return false;
            
   //Logic: Check Leading and traling digits and if they are same remove them and continue.  
   
       int divisor=1;
       while(x/divisor>=10)
            divisor*=10;
        
        while(x!=0){
            int leading=x/divisor;
            int trailing=x%10;
            if(leading!=trailing)
                return false;
            
            x=(x%divisor)/10;
            divisor/=100;
        }
        return true;
    }
}
