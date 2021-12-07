class Solution {
public:
    bool judgeCircle(string moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves[i] == 'R') {
                ++y;
            } else if (moves[i] == 'L') {
                --y;
            } else if (moves[i] == 'U') {
                --x;
            } else {
                ++x;
            }
        }
        if (x == 0 and y == 0) {
            return true;
        }
        return false;
    }
};
