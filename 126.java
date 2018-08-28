class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();
        List<List<String>> ans = new LinkedList<>();
        List<String> tmp = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        
        if (!dict.contains(endWord)) 
            return ans;
        
        // convert wordlist to graph
        build(graph, dict, beginWord);
        
        // get min steps from bfs
        int len = bfs(graph, beginWord, endWord);
        System.out.println(len);
        
        
        // build path from dfs  
        tmp.add(beginWord);
        dfs(graph, ans, tmp, beginWord, endWord, len);
        
        return ans;
    }
    
    public void dfs(Map<String, Set<String>> graph, List<List<String>> ans, List<String> tmp, 
                    String cur, String end, int len) {
        
        if (len == 0) {
            if (cur.equals(end)) ans.add(new ArrayList<String>(tmp));
            
            return;
        }
        
        if (graph.get(cur).size() == 0) 
            return;
 
        for (String next: graph.get(cur)) {
            tmp.add(next);
            dfs(graph, ans, tmp, next, end, len - 1);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    public int bfs(Map<String, Set<String>> graph, String beg, String end) {
        Queue<String> queue = new LinkedList<>();
        int ans = Integer.MAX_VALUE, cur = 1;
        boolean found = false;
        
        queue.offer(beg);
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                graph.putIfAbsent(curr, new HashSet<String>());
                
                for (String next: graph.get(curr)) {
                    queue.offer(next);
                        
                    if (next.equals(end)) {
                        ans = Math.min(cur, ans);
                        found = true;
                    }
                }
            }
            
            cur += 1;
        }
        
        return ans;
    }
    
    public void build(Map<String, Set<String>> graph, Set<String> dict, String beg) {
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(beg);
        while (!queue.isEmpty()) {
            Set<String> bin = new HashSet<>();
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                graph.putIfAbsent(curr, new HashSet<String>());
                
                for (int j = 0; j < curr.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        String next = curr.substring(0, j) + k + curr.substring(j + 1);

                        if (next.equals(curr) || next.equals(beg)) {
                            continue;
                        }
                        
                        if (dict.contains(next)) {
                            queue.offer(next);
                            bin.add(next);
                            graph.get(curr).add(next);
                        }
                    }
                }
            }
            
            for (String b: bin) {
                dict.remove(b);
            }
        }
    }
}