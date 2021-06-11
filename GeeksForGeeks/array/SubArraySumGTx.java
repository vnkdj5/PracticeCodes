// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.sb(a, n, m));
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {

    public static long sb(long a[], long n, long x) {
    
    int start=0, end=0, minLen=a.length+1, sum=0;
    while(end<n){
        
        while(sum<=x && end<n)
            sum+=a[end++];
            
        while(sum>x && start<n){
            if((end-start)<minLen)
                minLen=(end-start);
                
            sum-=a[start++];
        }
    }
    return minLen;
    }
}

