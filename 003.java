class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, ans = 0;
        
        while (r < s.length()) {
            // null or 
            if (map.get(s.charAt(r)) == null || map.get(s.charAt(r)) == 0) {
                map.put(s.charAt(r), 1);
                r++;
            }
            else {
                while (map.get(s.charAt(r)) != 0) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    l++;
                }    
            }
            
            ans = Math.max(ans, r - l);
        }
        
        return ans;
    }
}