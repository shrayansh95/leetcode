class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        if (n < 4)
            return false;
        int sum = 0;
        for (int it : matchsticks)
            sum += it;
        if (sum % 4 != 0)
            return false;
        int sides[] = new int[4];
        Arrays.sort(matchsticks);
        return solve(matchsticks, sides, n - 1, sum / 4);
    }
    private boolean solve(int matchsticks[], int sides[], int i, int target) {
        if (i < 0) {
            if (sides[0] == target && sides[1] == target && sides[2] == target)
                return true;
            return false;
        }
        for (int j = 0; j < 4; ++j) {
            if (sides[j] + matchsticks[i] > target)
                continue;
            sides[j] += matchsticks[i];
            if (solve(matchsticks, sides, i - 1, target))
                return true;
            sides[j] -= matchsticks[i];
        }
        return false;
    }
}