class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        
        while (i >= 0 || j >= 0) {
            int cur = carry;
                    
            if (i >= 0 && a.charAt(i) == '1') cur += 1;
            if (j >= 0 && b.charAt(j) == '1') cur += 1;
            
            carry = cur / 2;
            cur = cur % 2;
            
            sb.append((char) ('0' + cur));
            
            i--;
            j--;
        }
        
        if (carry == 1) sb.append('1');
        
        return sb.reverse().toString();
    }
}