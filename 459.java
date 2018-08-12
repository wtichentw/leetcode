class Solution {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            String pat = s.substring(0, i);
            
            // append
            while (sb.length() < s.length()) 
                sb.append(pat);
            
            // only compare if same length
            if (sb.length() == s.length() && sb.toString().equals(s))
                return true;
            else 
                sb.setLength(0);
        }
        
        return false;
    }
}