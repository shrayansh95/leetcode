class Solution {
    public String reverseWords(String s) {
        char arr[] = s.toCharArray();
        int len = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            if (arr[i] != ' ' || (len > 0 && arr[len - 1]  != ' '))
                arr[len++] = arr[i];
        }
        if (len > 0 && arr[len - 1] == ' ')
            --len;
        arr = Arrays.copyOf(arr, len);
        reverse(arr, 0, len - 1);
        int j = 0;
        for (int i = 0; i <= len; ++i) {
            if (i == len ||arr[i] == ' ') {
                reverse(arr, j, i - 1);
                j = i + 1;
            }
        }
        return new String(arr);
    }
    private void reverse(char arr[], int i, int j) {
        char temp;
        while (i < j) {
            temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}