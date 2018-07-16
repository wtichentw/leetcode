class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int[] pos = new int[26];
        int n = 0;
        
        // build pos
        Arrays.fill(pos, -1);
        for (int i = 0; i < s.length(); i++) {
            if (pos[s.charAt(i) - 'a'] == -1) n++;
            pos[s.charAt(i) - 'a'] = i;
        }
    
        // find
        int beg = 0, end = getMinLastPos(pos);
        for (int i = 0; i < n; i++) {
            
            char min = 'z' + 1;
            
            for (int j = beg; j <= end; j++) {
                if (pos[s.charAt(j) - 'a'] != -1 && s.charAt(j) < min) {
                    min = s.charAt(j);        
                    beg = j + 1;
                }
            }
            
            sb.append(min);
            pos[min - 'a'] = -1;
            
            if (sb.length() == n)
                break;
            
            end = getMinLastPos(pos);
        }
    
        return sb.toString();    
    }

    public int getMinLastPos(int[] pos) {
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < 26; i++) {
            if (pos[i] != -1 && pos[i] < ans) ans = pos[i];
        }
        
        return ans;
    }
}