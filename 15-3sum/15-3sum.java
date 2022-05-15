class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 3)
            return ans;
        Arrays.sort(nums);
        int lo, hi, rem;
        for (int i = 0; i <= n - 3; ++i) {
            lo = i + 1;
            hi = n - 1;
            rem = -nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] == rem) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[lo]);
                    temp.add(nums[hi]);
                    ans.add(temp);
                    while ((lo < hi) && (nums[lo] == nums[lo + 1]))
                        ++lo;
                    while ((lo < hi) && (nums[hi] == nums[hi - 1]))
                        --hi;
                    ++lo;
                    --hi;
                } else if (nums[lo] + nums[hi] > rem)
                    --hi;
                else 
                    ++lo;
            }
            while ((i + 1 < n) && (nums[i] == nums[i + 1])) 
                ++i;
        }
        return ans;
    }
}