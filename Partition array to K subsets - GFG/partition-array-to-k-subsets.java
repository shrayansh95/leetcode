// { Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	    // Your code here	
	    if (k > n) {
	        return false;
	    }
	    int sum = 0;
	    for (int it : a) {
	        sum += it;
	    }
	    if (sum % k != 0) {
	        return false;
	    }
	    boolean visited[] = new boolean[n];
	    Arrays.sort(a);
	    return dfs(a, 0, n - 1, visited, sum / k, k);
    }
    
    private boolean dfs(int a[], int sum, int st, boolean visited[], int target, int k) {
        if (k == 0) {
            return true;
        }
        if (sum == target && dfs(a, 0, a.length - 1, visited, target, k - 1)) {
            return true;
        }
        for (int i = st; i >= 0; --i) {
            if (!visited[i] && sum + a[i] <= target) {
                visited[i] = true;
                if (dfs(a, sum + a[i], i - 1, visited, target, k)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
