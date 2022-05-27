class Solution {
    public int numberOfSteps(int num) {
        if (num == 0)
            return 0;
        int ans = 0;
        while (num != 0) {
            // 1. if the number is even we just need to right shift it so +1
            // 2. If the number is odd we have to flip the last bit to make it 
            // even and then do a right shift hence +2
            ans += ((num & 1) == 0 ? 1 : 2);
            num >>= 1;
        }
        // we do -1 for the last 1 bit it is odd but we just need to subtract
        // not divide it by 2 hence we do -1 for removing the extra step
        return ans - 1;
    }
}