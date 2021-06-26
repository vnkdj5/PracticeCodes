class Solution {
    
    //Idea: if number has only prime factors i.e. 2,3 , 5 Whwn we completely
    //Divide it, it will be remaining with value 1, then its ugly number 
    public boolean isUgly1(int n) {
        for(int i=2;i<=5 && n>0;i++){
            while(n%i==0)
                n=n/i;
        }
        return n==1;
    }
    
     public boolean isUgly(int n) {
         if(n<=0)
             return false;
        while(n%2==0) n=n/2;
        
         while(n%3==0) n=n/3;
         
         while(n%5==0) n=n/5;
         
        return n==1;
    }
    
}
