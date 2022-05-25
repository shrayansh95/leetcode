// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int dir[] = new int[]{0, -1, 0, 1, 0};
        char dir1[] = new char[]{'L', 'U', 'R', 'D'};
        StringBuilder str = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();
        solve(m, 0, 0, n, str, ans, dir, dir1);
        return ans;
    }
    
    private static void solve(int m[][], int r, int c, int n, StringBuilder str, ArrayList<String> ans, int dir[], char dir1[]) {
        if (r < 0 || r >= n || c < 0 || c >= n || m[r][c] == 0) {
            return;
        }
        if (r == n - 1 && c == n - 1) {
            ans.add(str.toString());
            return;
        }
        int nr, nc;
        m[r][c] = 0;
        for (int i = 0; i < 4; ++i) {
            nr = r + dir[i];
            nc = c + dir[i + 1];
            str.append(dir1[i]);
            solve(m, nr, nc, n, str, ans, dir, dir1);
            str.deleteCharAt(str.length() - 1);
        }
        m[r][c] = 1;
    }
}