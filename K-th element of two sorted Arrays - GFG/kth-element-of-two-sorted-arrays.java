// { Driver Code Starts
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
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if (n > m) 
            return kthElement(arr2, arr1, m, n, k);
        int low = Math.max(0, k - m), high = Math.min(k, n), cut1, cut2, left1, left2, right1, right2;
        while (low <= high) {
            cut1 = (low + high) >> 1;
            cut2 = k - cut1;
            
            left1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            left2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            
            right1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            right2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];
            
            if (left1 <= right2 && left2 <= right1) 
                return Math.max(left1, left2);
            else if (left1 > right2) 
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }
        return 1;
    }
}