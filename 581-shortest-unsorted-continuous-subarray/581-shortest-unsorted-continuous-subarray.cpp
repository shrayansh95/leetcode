class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int start = -1, end = -1;
        int n = nums.size();
        int flag = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] > nums[j]) {
                    flag = 1;
                    start = i;
                    break;
                }
            } 
            if (flag)
                break;
        }
        if (start == -1)
            return 0;
        flag = 0;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] < nums[j]) {
                    flag = 1;
                    end = i;
                    break;
                }
            }
            if (flag)
                break;
        }
        return (end - start + 1);
    }
};