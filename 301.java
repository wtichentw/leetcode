class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new LinkedList<>();   
        int l = 0, r = 0;

        // how many ( and ) needed to be removed
        for (char c: s.toCharArray()) {
            if (c == '(') {
                l++;
            }
            if (c == ')') {
                if (l > 0) l--;
                else r++;
            }
        }
        
        dfs(ans, s, 0, l, r);
        
        return ans;
    }
    
    public void dfs(List<String> ans, String str, int idx, int l, int r) {
        if (l == 0 && r == 0) {
            if (validate(str)) ans.add(new String(str));
            
            return;
        }
        
        for (int i = idx; i < str.length(); i++) {
            if (i != idx && str.charAt(i) == str.charAt(i - 1)) continue;
            
            String next = str.substring(0, i) + str.substring(i + 1);
            
            if (l > 0 && str.charAt(i) == '(') {
                dfs(ans, next, i, l - 1, r   );
            }
            if (r > 0 && str.charAt(i) == ')') {
                dfs(ans, next, i, l    , r - 1);
            }
        }
    }
    
    public boolean validate(String s) {
        int cnt = 0;
        
        for (char c: s.toCharArray()) {
            if (c == '(') cnt++;
            if (c == ')') cnt--;
            if (cnt < 0) return false;
        }
        
        return cnt == 0;
    }
}