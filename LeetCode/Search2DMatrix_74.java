class Solution {
  //Consider it as a sorted 1D array converted to 2d array..Binarysearch approch
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0, high=matrix.length*matrix[0].length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int i=mid/(matrix[0].length); //matrix[0].length ==> no of columns
            int j=mid%(matrix[0].length);
            if(matrix[i][j]==target)
                return true;
            if(matrix[i][j]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return false;
    }
}
