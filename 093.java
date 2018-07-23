class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        
        backtrack(ans, new StringBuilder(), s, 0, 0);
        
        return ans;
    }
    
    public void backtrack(List<String> ans, StringBuilder sb, String s, int idx, int lvl) {
        // terminal
        if (lvl == 4) {
            if (idx == s.length()) ans.add(sb.toString());
            else return;
        }
        
        for (int i = 1; i <= 3; i++) {
            // index check
            if (idx + i > s.length()) continue;
            
            String seg = s.substring(idx, idx + i);
            int val = Integer.valueOf(seg);
            
            // cant start wit 0
            if (seg.length() > 1 && seg.charAt(0) == '0') continue;
            
            // [0, 255]
            if (val >= 0 && val <= 255) {
                sb.append(seg);
                if (lvl != 3) sb.append('.');
                
                backtrack(ans, sb, s, idx + i, lvl + 1);
                
                sb.setLength(sb.length() - seg.length());
                if (lvl != 3) sb.setLength(sb.length() - 1);
            }
        }
    }
}