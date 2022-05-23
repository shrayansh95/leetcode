class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int one, zero, temp, temp1 = strs.length;
        Count arr[] = new Count[temp1];
        for (int i = 0; i < temp1; ++i) {
            one = 0;
            zero = 0;
            temp = strs[i].length();
            for (int j = 0; j < temp; ++j) {
                if (strs[i].charAt(j) == '1')
                    ++one;
                else
                    ++zero;
            }
            arr[i] = new Count(zero, one);
        }
        int dp[][][] = new int[temp1][m + 1][n + 1];
        for (int[][] it : dp) 
            for (int[] it1 : it)
                Arrays.fill(it1, -1);
        return solve(arr, 0, temp1, m, n, dp);
    }
    
    private int solve(Count arr[], int i, int size, int m, int n, int dp[][][]) {
        if (i == size || (m == 0 && n == 0)) 
            return 0;
        if (dp[i][m][n] != -1)
            return dp[i][m][n];
        if (arr[i].zero > m || arr[i].one > n)
            return dp[i][m][n] = solve(arr, i + 1, size, m, n, dp);
        int take = 1 + solve(arr, i + 1, size, m - arr[i].zero, n - arr[i].one, dp);
        int notTake = solve(arr, i + 1, size, m, n, dp);
        return dp[i][m][n] = Math.max(take, notTake);
    }
}

class Count {
    int one, zero;
    Count(int a, int b) {
        this.zero = a;
        this.one = b;
    }
}