class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        long long ans = 0LL;
        int n = nums.size();
        int maxi, mini;
        for (int s = 0; s < n; s++) {
            maxi = INT_MIN;
            mini = INT_MAX;
            for (int e = s; e < n; e++) {
                if (nums[e] > maxi) maxi = nums[e];
                if (nums[e] < mini) mini = nums[e];
                ans += (maxi - mini);
            }
        } 
        return ans;
    }
};
