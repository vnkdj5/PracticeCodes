// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    
    int rowWithMax1s(int arr[][], int n, int m) {
        int index=-1;
        
        int j=m-1; //start with last column
        
        for(int i=0;i<n;i++){
            
            //We will traverse columsn left will we find 1
            //This way we will only runbelow loop m times O(n+m)
            while(j>=0 && arr[i][j]==1){
                j--;
                index=i;
            }
            
        }
        return index;
    }
    int rowWithMax1s_WORST(int arr[][], int n, int m) {
        int index=-1;
        int cur=0, max=0;
        for(int i=0;i<n;i++){
            cur=0;
            for(int j=0;j<m;j++){
                if(arr[i][j]==1)
                    cur++;
            }
            if(cur>max){
                max=cur;
                index=i;
            }
            
        }
        
        return index;
    }
}
