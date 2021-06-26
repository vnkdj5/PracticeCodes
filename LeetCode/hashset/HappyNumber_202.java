class Solution {
    

    public boolean isHappy1(int n) {
    
    HashSet<Integer> hs=new HashSet<>();
    /*
    Idea: If we encounter the sum(n) again then it means its a loop
    Hashset will store our all sums, It returns false when we add already existing element, Thats our exit condition.
    
    */
      while(hs.add(n)){
        int sum=0;
        while(n!=0){
            int rem=n%10;
            sum=sum+(rem*rem);
            n=n/10;
        }
        n=sum;
        if(sum==1)
            return true;
      }
        return false;
        
    }
    
    
    public boolean isHappy(int n) {
        //https://en.wikipedia.org/wiki/Happy_number
         if(n<10){
           /*
           Under 10 only 2 happy numbers  are present: 1 & 7 
           This will be base case, for other numbers there will be no happy number
                 
           */
             if(n==1 || n==7) 
                 return true;
             return false;
         }
         
         int sum=0;
        while(n!=0){
            int rem=n%10;
            sum=sum+(rem*rem);
            n=n/10;
        }
         return isHappy(sum);
         
         
         
     }
}
