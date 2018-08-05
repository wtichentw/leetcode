class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int i = 0, j = 0;
        int[] map = new int[256];
        
        Arrays.fill(map, 0);
        
        for (char c: s1.toCharArray()) {
            map[c]++;
        }
        
        while (i < s2.length()) {
            if (--map[s2.charAt(i)] < 0) {
                while (++map[s2.charAt(j++)] != 0) ;
            }
            
            if (i - j + 1 == s1.length()) 
                return true;
            
            i++;
        }     
        
        return false;
    }
}