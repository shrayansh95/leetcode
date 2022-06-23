class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int cur = 0, n = courses.length;
        for (int i = 0; i < n; ++i) {
            if  (cur + courses[i][0] <= courses[i][1]) {
                cur += courses[i][0];
                pq.add(courses[i][0]);
            } else if (!pq.isEmpty() && pq.peek() > courses[i][0]) {
                cur -= pq.poll();
                cur += courses[i][0];
                pq.add(courses[i][0]);
            }
        }
        return pq.size();
    }
}