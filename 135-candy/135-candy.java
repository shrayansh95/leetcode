class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int i = 0,
        s = 0, // stores the start index of the left or right sides of the peak
        ans = 1; //initialize as 1 because in each round we minus 1 for the left 
                 // bottom since it was calculated once in the previous round
        int left, right; // to store the length of the respective halves
        int peak; // stores the candies in peak element
        while (i < n - 1) {
            // min to peak element 
            while (i < n - 1 && ratings[i] < ratings[i + 1])
                ++i;
            // size of left half 
            left = i - s;
            s = i;
            // peak to min element 
            while (i < n - 1 && ratings[i] > ratings[i + 1])
                ++i;
            // size of right half 
            right = i - s;
            s = i;
            peak = Math.max(left, right) + 1;
            // the minus 1 is because we are taking the previous min from 
            // prev right half 
            ans += (left * (left + 1)) / 2 + (right * (right + 1)) / 2 
                    + peak - 1;
            // Add 1 for each duplicate element 
            while (i < n - 1 && ratings[i] == ratings[i + 1]) {
                ++i;
                ++ans;
            }
            s = i;
        }
        return ans;
    }
}