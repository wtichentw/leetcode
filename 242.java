class Solution {
    public boolean isAnagram(String s, String t) {
        int[] m = new int[26];
        
        for (char c : s.toCharArray()) 
            m[c - 'a']++;
        
        for (char c : t.toCharArray()) 
            if (--m[c - 'a'] < 0) return false; 
        
        for (int n : m)
            if (n != 0) return false;
        
        return true;
    }
}