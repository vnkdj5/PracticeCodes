class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }else
            {
                digits[i]++;
                return digits;
            }
        }
        int []nums=new int[digits.length+1];
        nums[0]=1;
//         for(int i=1;i<=digits.length;i++){
//             nums[i]=digits[i-1];
//         }
        
        return nums;
    }
}
