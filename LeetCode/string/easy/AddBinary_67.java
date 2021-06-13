class Solution {
    public String addBinary(String a, String b) {
        int m=a.length()-1, n=b.length()-1;
        int sum=0, carry=0;
        StringBuffer ans=new StringBuffer();
        while(m>=0 || n>=0){
            
            sum=carry;
            if(m>=0) sum+=a.charAt(m--)-'0';
            if(n>=0) sum+=b.charAt(n--)-'0';
            ans.append(sum%2);
            carry=sum/2;
        }
        if(carry==1)
            ans.append(carry);
        return ans.reverse().toString();
    }
}
