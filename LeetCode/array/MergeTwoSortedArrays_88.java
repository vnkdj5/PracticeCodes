class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=m+n-1;
        int a=Integer.MIN_VALUE,b=Integer.MIN_VALUE;
        while(m>0 || n>0){ // OR index>=0
            a=(m>0)?nums1[m-1]:Integer.MIN_VALUE;
            b=(n>0)?nums2[n-1]:Integer.MIN_VALUE;
            if(a>b){
                nums1[index--]=a;
                m--;
            }else{
                nums1[index--]=b;
                n--;
            }
        }
    }
}
