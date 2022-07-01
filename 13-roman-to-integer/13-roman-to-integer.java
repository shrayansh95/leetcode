class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0, temp = 0, n = s.length(), i = 0;
        while (i < n) {
            if (i < n - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                temp += map.get(s.charAt(i++));
            }
            ans += map.get(s.charAt(i++)) - temp;
            temp = 0;
        }
        return ans;
    }
}