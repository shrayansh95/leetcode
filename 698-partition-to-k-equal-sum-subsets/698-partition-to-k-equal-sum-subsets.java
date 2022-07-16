class Solution {
    public boolean canPartitionKSubsets(int[] a, int k) {
        int n = a.length;
        if (k > n) 
	        return false;
	    int sum = 0;
	    for (int it : a) 
	        sum += it;
	    if (sum % k != 0) 
	        return false;
	    boolean visited[] = new boolean[n];
	    Arrays.sort(a);
	    return dfs(a, 0, n - 1, visited, sum / k, k);
    }
    private boolean dfs(int a[], int sum, int st, 
                        boolean visited[], int target, int k) {
        if (k == 0) 
            return true;
        if (sum == target && 
            dfs(a, 0, a.length - 1, visited, target, k - 1)) 
            return true;
        for (int i = st; i >= 0; --i) {
            if (!visited[i] && sum + a[i] <= target) {
                visited[i] = true;
                if (dfs(a, sum + a[i], i - 1, visited, target, k)) 
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}