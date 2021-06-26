class Solution {
    
    public int addDigits(int num) {
       
        while(true){
             int sum=0;
            if((num/10)==0)
            return num;
        while(num!=0){
            sum+=num%10;
            num=num/10;
        }
           num=sum; 
        }
       
       
    }
    
    
    public int addDigits_Rec(int num) {
        int sum=0;
        if((num/10)==0)
            return num;
        while(num!=0){
            sum+=num%10;
            num=num/10;
        }
        return addDigits_Rec(sum);
    }
}
