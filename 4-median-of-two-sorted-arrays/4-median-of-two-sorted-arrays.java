class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) 
            return findMedianSortedArrays(nums2, nums1);
        int leftSize = (n1 + n2 + 1) >> 1;
        int cur1, cur2, low = 0, high = n1, left1, left2, right1, right2;
        while (low <= high) {
            cur1 = (low + high) >> 1;
            cur2 = leftSize - cur1;
            
            left1 = cur1 == 0 ? Integer.MIN_VALUE : nums1[cur1 - 1];
            left2 = cur2 == 0 ? Integer.MIN_VALUE : nums2[cur2 - 1];
            
            right1 = cur1 == n1 ? Integer.MAX_VALUE : nums1[cur1];
            right2 = cur2 == n2 ? Integer.MAX_VALUE : nums2[cur2];
            
            if (left1 <= right2 && left2 <= right1) {
                if (((n1 + n2) & 1) == 1) 
                    return (double)Math.max(left1, left2);
                else 
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                high = cur1 - 1;
            } else {
                low = cur1 + 1;
            }
        }
        return 0.0;
    }
}