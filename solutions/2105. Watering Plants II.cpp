class Solution {
public:
    int minimumRefill(vector<int>& plants, int capacityA, int capacityB) {
        int count = 0;
        int cA = capacityA, cB = capacityB;
        int i = 0, j = plants.size() - 1;
        while (i <= j) {
            if (i == j) {
                if (cA > cB || cA == cB) {
                    if (plants[i] > cA) {
                        ++count;
                    }
                    ++i;
                } else {
                    if (plants[j] > cB) {
                        ++count;
                    }
                    --j;
                }
            } else {
                if (plants[i] > cA) {
                    ++count;
                    cA = capacityA;
                }
                if (plants[j] > cB) {
                    ++count;
                    cB = capacityB;
                }
                cA -= plants[i];
                cB -= plants[j];
                ++i, --j;
            }
        }
