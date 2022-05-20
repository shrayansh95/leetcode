class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i < n; ++i) {
            fact *= i;
            nums.add(i);
        }
        nums.add(n);
        k -= 1;
        char ans[] = new char[n];
        int i = 0;
        while (true) {
            ans[i++] = (char)(nums.get(k / fact) + 48);
            nums.remove(nums.get(k / fact));
            if (nums.size() == 0)
                break;
            k %= fact;
            fact /= nums.size();
        }
        return new String(ans);
    }
}