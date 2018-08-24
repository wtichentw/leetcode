class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        
        s = s.trim();
        
        boolean hasPoint = false, hasE = false;
        boolean numberSeen = false;
        
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
            } 
            else if (s.charAt(i) == '.') {
                if (hasPoint || hasE) return false;
                
                hasPoint = true;
            }
            else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (hasE || !numberSeen) return false;
                
                hasE = true;
                numberSeen = false;
            }
            else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            }
            else {
                return false;
            }
        }
        
        return numberSeen;
    }
}