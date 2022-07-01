class Solution {
    public int myAtoi(String s) {
        long number = 0;
        int sign = 1;
        int n = s.length(), i = 0;
        while (i < n && s.charAt(i) == ' ')
            ++i;
    
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            ++i;
        }
            
        
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            number = (number * 10) + (s.charAt(i++) - '0');
            if ((number * sign) >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if ((number * sign) <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        
        return (int)(number * sign);
    }
}