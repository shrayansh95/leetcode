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
        int dp[][][] = new int[temp1 + 1][m + 1][n + 1];
        
        for (int i = temp1; i >= 0; --i) {
            for (zero = 0; zero <= m; ++zero) {
                for (one = 0; one <= n; ++one) {
                    if (i == temp1 || (zero == 0 && one == 0)) {
                        dp[i][zero][one] = 0;
                        continue;
                    }
                    if (arr[i].zero > zero || arr[i].one > one) {
                        dp[i][zero][one] = dp[i + 1][zero][one];
                        continue;
                    }
                    int take = 1 + dp[i + 1][zero - arr[i].zero][one - arr[i].one];
                    int notTake = dp[i + 1][zero][one];
                    dp[i][zero][one] = Math.max(take, notTake);    
                }
            }
        }
        return dp[0][m][n];
    }
    
    // private int solve(Count arr[], int i, int size, int zero, int one, int dp[][][]) {
    //     if (i == size || (zero == 0 && one == 0)) 
    //         return 0;
    //     if (dp[i][zero][one] != -1)
    //         return dp[i][zero][one];
    //     if (arr[i].zero > zero || arr[i].one > one)
    //         return dp[i][zero][one] = solve(arr, i + 1, size, zero, one, dp);
    //     int take = 1 + solve(arr, i + 1, size, zero - arr[i].zero, one - arr[i].one, dp);
    //     int notTake = solve(arr, i + 1, size, zero, one, dp);
    //     return dp[i][zero][one] = Math.max(take, notTake);
    // }
}

class Count {
    int one, zero;
    Count(int a, int b) {
        this.zero = a;
        this.one = b;
    }
}