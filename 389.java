public class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char ans = '\0';
        
        for (char c: s.toCharArray()) {
            if (map.get(c) == null)
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);
        }
        
        for (char c: t.toCharArray()) {
            if (map.get(c) == null || map.get(c) == 0) 
                ans = c;
            else 
                map.put(c, map.get(c) - 1);
        }
        
        return ans;
    }
}