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
    
    
    public int maxProfit_Approch2(int[] a) {
        int profit=0;
        int peak=a[0];
        int valley=a[0];
        int i=0;
        while(i<a.length-1){
            
            while(i<a.length-1 && a[i]>=a[i+1]){
                i++;
            }
            valley=a[i];
            
            while(i<a.length-1 && a[i]<=a[i+1]){
                i++;
            }
            peak=a[i];
            profit+=(peak-valley);
                
            
        }
        return profit;
        
        
    }
}
