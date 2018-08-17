class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1, n = s.length();
        
        while (i < j) {
            while (i <  n && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) j--;
            
            if (i < n && j >= 0 && 
                Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) return false;
        }
        
        return true;
    }
}