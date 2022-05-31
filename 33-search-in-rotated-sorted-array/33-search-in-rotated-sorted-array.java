class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[low] <= nums[mid]) {
                // left part is sorted
                if (target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else 
                    low = mid + 1;;
            } else {
                // right part is sorted 
                if (target <= nums[high] && target > nums[mid])
                    low = mid + 1;
                else 
                    high = mid - 1;
            }
        }
        return -1;
    }
}