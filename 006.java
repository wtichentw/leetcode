class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        String[] strs = new String[numRows];
        String ans = "";
        int row = 0;
        boolean down = true;
        
        Arrays.fill(strs, "");
        
        for (int i = 0; i < s.length(); i++) {
            strs[row] = strs[row] + s.charAt(i);

            row += down?  1: -1;
            
            if (row == numRows) {
                row = row - 2;
                down = false;
            } 
            if (row == -1) {
                row = -1 + 2;
                down = true;
            }
        }
        
        for (String str: strs) {
            ans = ans + str;
        }
        
        return ans;
    }
}