class Solution {
    public int myAtoi(String s) {
        int number = 0;
        int sign = 1;
        int n = s.length(), i = 0;
        while (i < n && s.charAt(i) == ' ')
            ++i;
    
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            ++i;
        }
            
        int digit;
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            digit = s.charAt(i++) - '0';
            if (Integer.MAX_VALUE / 10 < number || Integer.MAX_VALUE / 10 == number && Integer.MAX_VALUE % 10 < digit)
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            number = (number * 10) + digit;
        }
        
        return (number * sign);
    }
}