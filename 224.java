class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Integer> signs = new Stack<Integer>();
        int prev = 0, curr = 0, sign = 1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }
            else if (c == '+') {
                prev += sign * curr;
                curr = 0;
                sign = 1;
            }
            else if (c == '-') {
                prev += sign * curr;
                curr = 0;
                sign = -1;
            }
            else if (c == '(') {
                nums.push(prev);
                signs.push(sign);
                prev = 0;
                curr = 0;
                sign = 1;
            }
            else if (c == ')') {
                prev += sign * curr;
                prev *= signs.pop();
                prev += nums.pop();
                curr = 0;
            }
        }
        
        if (curr != 0) prev += sign * curr;

        return prev;
    }
}