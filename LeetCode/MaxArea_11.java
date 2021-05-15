class Solution {
    //two pointers approch
    public int maxArea(int[] a) {
        int max=Integer.MIN_VALUE;
        int n=a.length;
        int i=0, j=n-1;
        while(i<j){
            int l=Math.min(a[i], a[j]);
            int b=j-i;
            int area=l*b;
            if(area>max)
                max=area;
            if(l==a[i]) //compromise width for finding the longer length container
                i++;
            else
                j--;
        }
        
        return max;
    }
}

/*
Hint 2: Start with the maximum width container and go to a shorter width container if there is a vertical line longer than the current containers shorter line. This way we are compromising on the width but we are looking forward to a longer length container.

*/
