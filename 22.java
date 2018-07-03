class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        helper(ans, sb, n, 0, 0);
        
        return ans;
    }
    
    public void helper(List<String> ans, StringBuilder sb, int n, int l, int r) {
        if (l > n || r > n) {
            return;
        }
        if (sb.length() == n * 2) {
            ans.add(sb.toString());
            return;
        }
        
        if (l == r) { // insert ( only
            sb.append('(');
            helper(ans, sb, n, l + 1, r);
            sb.setLength(sb.length() - 1);            
        }
        else if (l > r) { // can try both
            sb.append('(');
            helper(ans, sb, n, l + 1, r);
            sb.setLength(sb.length() - 1);            
            
            sb.append(')');
            helper(ans, sb, n, l, r + 1);
            sb.setLength(sb.length() - 1);            
        }
    }
}