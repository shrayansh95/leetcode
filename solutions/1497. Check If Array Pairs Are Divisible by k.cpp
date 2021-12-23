class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        vector<int> freq(k, 0);
        int mod;
        for (int i = 0; i < arr.size(); i++) {
            mod =  arr[i] % k;
            if (mod < 0) {
                mod += k;
            }
            ++freq[mod];
        }
        if (freq[0] & 1) {
            return false;
        }
        for (int i = 1; i <= (k / 2); i++) {
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }
        return true;
    }
};
