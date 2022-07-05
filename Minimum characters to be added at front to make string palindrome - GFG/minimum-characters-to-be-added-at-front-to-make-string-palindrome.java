// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


 // } Driver Code Ends
//User function Template for Java

class Solution {
    public static int minChar(String str) {
       //Write your code here
        int n = str.length();
        StringBuilder s = new StringBuilder();
        s.append(str);
        s.reverse();
        str += '$';
        str += s.toString();
        int m = str.length();
        int table[] = new int[m];
        int i = 0, j = 1;
        while (j < m) {
            if (str.charAt(i) == str.charAt(j)) 
                table[j++] = ++i;
            else {
                if (i == 0)
                    ++j;
                else 
                    i = table[i - 1];
            }
        }
        return (n - table[m - 1]);
    }
}

// { Driver Code Starts.

class GFG {
	public static void main(String[] args) throws IOException
	{
	    var sc = new FastReader();
	    int test = sc.nextInt();
	    while(test-->0){
    		String s = sc.nextString();
    		System.out.println(Solution.minChar(s));
	    }
	}
    
    public static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		private void read() throws IOException
		{
			st = new StringTokenizer(br.readLine());
		}

		public String nextString() throws IOException
		{
			while(!st.hasMoreTokens())
				read();
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(nextString());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(nextString());
		}
	}
}  // } Driver Code Ends