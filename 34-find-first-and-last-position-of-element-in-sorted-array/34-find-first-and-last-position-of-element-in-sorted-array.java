class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[]{-1, -1};
        int n = nums.length;
        binarySearch(nums, 0, n - 1, target, true, ans);
        binarySearch(nums, 0, n - 1, target, false, ans);
        return ans;
    }
    private void binarySearch(int nums[], int start, int end, int target, boolean first, int ans[]) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (first) {
                    end = mid - 1;
                    ans[0] = mid;
                } else {
                    start = mid + 1;
                    ans[1] = mid;
                }
            } else if (nums[mid] < target) 
                start = mid + 1;
            else 
                end = mid - 1;
        }
    }
}