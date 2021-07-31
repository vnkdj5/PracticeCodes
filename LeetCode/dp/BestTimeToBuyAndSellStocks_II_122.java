class Solution {
    public int maxProfit(int[] a) {
        int profit=0;
        for(int i=0;i<a.length-1;i++){
            if(a[i+1]-a[i]>0){
                profit=profit+(a[i+1]-a[i]);
                }
        }
        return profit;
    }
}
