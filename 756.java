class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<String>> map = new HashMap<>();
        
        for (String str: allowed) {
            String bot = str.substring(0, 2);
            String top = str.substring(2, 3);
            
            if (map.get(bot) == null) 
                map.put(bot, new HashSet<String>());
            
            map.get(bot).add(top);
        }
        
        return DFS(map, bottom, "", 0);
    }
    
    public boolean DFS(Map<String, Set<String>> map, String prev, String curr, int idx) {
        // last level
        if (prev.length() == 2 && map.get(prev) != null) 
            return true;
        
        String key = prev.substring(idx, idx + 2);
        
        // no block to build
        if (map.get(key) == null)
            return false;
        
        for (String block: map.get(key)) {
            String next = curr + block;
            boolean build = false;
            
            if (next.length() == prev.length() - 1) 
                build = DFS(map, next, "", 0);
            else 
                build = DFS(map, prev, next, idx + 1);
            
            if (build) 
                return true;
        }
        
        return false;
    }
}