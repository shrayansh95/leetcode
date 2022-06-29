class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (int a[], int[] b) -> {
            return a[0] != b[0] ? b[0] - a[0]  : a[1] - b[1];
        });
        List<int[]> ans = new ArrayList<>();
        for (int it[] : people) {
            ans.add(it[1], it);
        }
        return ans.toArray(new int[people.length][2]);
    }
}