class Solution {
    public String minWindow(String s, String t) {
        int[] map1 = new int[256]; // map for t
        int[] map2 = new int[256]; // map for s
        int i = 0, j = 0, cnt1 = 0, cnt2 = 0;
        
        for (char c: t.toCharArray()) {
            map1[c]++;
            cnt1++;
        }
        
        int mi = 0, mj = 0, mlen = Integer.MAX_VALUE;
        
        // always make [i, j] legal substring
        while (j < s.length()) {
            // expand left
            ++map2[s.charAt(j)];
            
            // calculate count, add only we have left capacity
            if (map2[s.charAt(j)] <= map1[s.charAt(j)]) {
                cnt2++;
            }
            
            // shrink left
            if (cnt2 == cnt1) {
                while (map2[s.charAt(i)] > map1[s.charAt(i)]) {
                    map2[s.charAt(i)]--;
                    i++;
                }
                
                // update 
                if (j - i < mlen) {
                    mi = i;
                    mj = j + 1;
                    mlen = j - i;
                }
            }
                
            j++;
        }
        
        return s.substring(mi, mj);
    }
}