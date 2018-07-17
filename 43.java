class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n1 = num1.length(), n2 = num2.length();
        int[] ans = new int[n1 + n2];
        
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                ans[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        
        for (int i = 0; i < n1 + n2; i++) {
            if (ans[i] >= 10) {
                ans[i + 1] += ans[i] / 10;
                ans[i] = ans[i] % 10;
            }
            sb.insert(0, (char) (ans[i] + '0'));
        }
        
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        
        return sb.toString();
    } 
}