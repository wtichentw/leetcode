class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[26];
        
        for (char c: p.toCharArray()) {
            map[c - 'a']++;
        }
        
        int r = 0, l = 0;
        while (r < s.length()) {
            // can substract
            if (map[s.charAt(r) - 'a'] >= 1) {
                map[s.charAt(r) - 'a']--;
                r++;
            }
            else {
                map[s.charAt(r) - 'a']--;
                r++;
                
                while (map[s.charAt(l) - 'a'] >= 0) {
                    map[s.charAt(l) - 'a']++;
                    l++;
                }
                
                map[s.charAt(l) - 'a']++;
                l++;
            }
            
            if (r - l == p.length()) ans.add(l);
        }
        
        return ans;
    }
}