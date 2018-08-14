class Solution {
    public int maximumSwap(int num) {
        int[] loc = new int[10];
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        
        // 115
        // 511
        // 1993 
        // 9913
        
        // record the loc from right
        for (int i = 0; i < n; i++) {
            loc[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) {
                if (loc[j] > i) {
                    int idx = loc[j];
                    char tmp = digits[i];
                    digits[i] = digits[idx];
                    digits[idx] = tmp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        return num;        
    }
}