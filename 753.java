class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Set<String> visit = new HashSet<>();
        int size = (int) Math.pow(k, n);
        
        // start point
        for (int i = 0; i < n; i++) sb.append('0');
        visit.add(sb.toString());
        
        DFS(sb, visit, size, n, k);
        
        return sb.toString();
    }
    
    public boolean DFS(StringBuilder sb, Set<String> visit, int size, int n, int k) {
        if (visit.size() == size)
            return true;
        
        // 共用 n - 1 bits
        String prefix = sb.substring(sb.length() - (n - 1), sb.length());
                    
        for (char c = '0'; c < '0' + k; c++) {
            String next = prefix + c;
            
            if (visit.contains(next)) continue;
            
            visit.add(next);
            sb.append(c);
            if (DFS(sb, visit, size, n, k)) return true;
            sb.setLength(sb.length() - 1);
            visit.remove(next);
        }
        
        return false;
    }
}