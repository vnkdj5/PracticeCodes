class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
     int squares[]=new int[n];
       int s=0, e=n-1, i=n-1;
        while(s<=e){
            int ssq=nums[s]*nums[s], esq=nums[e]*nums[e];
            if(ssq>esq){
                squares[i]=ssq;
                s++;
            }else{
                squares[i]=esq;
                e--;
            }
            i--;
        }
        return squares;
    }
    
    
    
    public int[] sortedSquares_Basic(int[] nums) {
     int squares[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
        squares[i]=nums[i]*nums[i];
        }
        
        Arrays.sort(squares);
        return squares;
    }
}
