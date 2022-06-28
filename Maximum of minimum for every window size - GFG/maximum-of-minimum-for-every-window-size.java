// { Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}// } Driver Code Ends



class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        // Your code here
        Stack<Integer> st = new Stack<>();
        int left[] = new int[n], right[] = new int[n];
        
        // Right smaller 
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) 
                right[st.pop()] = i;
            st.push(i);
        }
        while (!st.isEmpty())
            right[st.pop()] = n;
        
        
        // Left smaller 
        for (int i = n - 1; i >= 0; --i) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i])
                left[st.pop()] = i;
            st.push(i);
        }
        while (!st.isEmpty())
            left[st.pop()] = -1;
            
            
        int ans[] = new int[n], len;
        for (int i = 0; i < n; ++i) {
            len = right[i] - left[i] - 2;
            ans[len] = Math.max(ans[len], arr[i]);
        }
        
        for (int i = n - 2; i >= 0; --i)
            ans[i] = Math.max(ans[i + 1], ans[i]);
            
        return ans;
    }
}