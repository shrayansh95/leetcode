class Solution {
    public int singleNonDuplicate(int[] nums) {
        int mid, low = 0, high = nums.length - 1;
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] == nums[mid ^ 1])
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low];
    }
}

