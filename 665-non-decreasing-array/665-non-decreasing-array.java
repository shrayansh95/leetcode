class Solution {
    public boolean checkPossibility(int[] nums) {
        int flag = 0, n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                if (flag == 1)
                    return false;
                if (i - 2 < 0 || nums[i] >= nums[i - 2])
                    nums[i - 1] = nums[i];
                else 
                    nums[i] = nums[i - 1];
                flag = 1;
            }           
        }
        return true;
    }
}