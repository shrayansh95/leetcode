class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean visited[] = new boolean[n + 1];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int t = times.length;
        for (int time[] : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        Queue<int[]> q = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        q.add(new int[]{k, 0});
        int temp[], curNode, curDist, ans = 0;
        while (!q.isEmpty()) {
            temp = q.remove();
            curNode = temp[0];
            curDist = temp[1];
            if(visited[curNode]) 
                continue;
            visited[curNode] = true;
            ans = curDist;
            --n;
            if (map.containsKey(curNode)) {
                for (int next : map.get(curNode).keySet()) {
                    q.add(new int[]{next, curDist + map.get(curNode).get(next)});
                }
            }
        }
        System.out.println(n);
        return (n == 0 ? ans : -1);
    }
}