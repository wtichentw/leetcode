class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        int ans = 0;
        
        for (char c: s.toCharArray()) {
            map[c - 'a']++;
        }
        
        for (char c: s.toCharArray()) {
            if (map[c - 'a'] == 1) return ans;
            ans++;
        }
        
        return -1;
    }
}