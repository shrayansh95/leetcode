// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        Interval inter[] = new Interval[n];
        for (int i = 0; i < n; ++i) 
            inter[i] = new Interval(start[i], end[i]);
        Arrays.sort(inter, new SortByEnd());
        int ans = 1;
        int last = inter[0].end;
        for (int i = 1; i < n; ++i) {
            if (last < inter[i].start) {
                last = inter[i].end;
                ++ans;
            }
        }
        return ans;
    }
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class SortByEnd implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.end - b.end;
    }
}