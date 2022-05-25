// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int color[] = new int[n];
        Arrays.fill(color, -1);
        return dfs(0, n, m, graph, color);
    }
    
    private boolean dfs(int v, int n, int m, boolean graph[][], int color[]) {
        if (v == n) return true;
        int flag = 0;
        for (int i = 1; i <= m; ++i) {
            flag = 1;
            for (int u = 0; u < n; ++u) {
                if (graph[v][u] && color[u] == i) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                color[v] = i;
                if (dfs(v + 1, n, m, graph, color)) return true;
                color[v] = -1;
            }
        }
        return false;
    }
}