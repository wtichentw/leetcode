class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0, remin = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            
            if (i >= 0) {
                sum += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j--;
            }
            
            carry = sum / 10;
            remin = sum % 10;
            
            sb.insert(0, remin);
        }
        
        if (carry != 0) sb.insert(0, carry);
        
        return sb.toString();
    }
}