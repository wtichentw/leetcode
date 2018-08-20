class Solution {
    public boolean isBipartite(int[][] graph) {
        // 0 - not visit
        // 1 - red
        // 2 - blue
        int[] visit = new int[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            // already visited
            if (visit[i] != 0) continue;
            
            Queue<Integer> q = new LinkedList<>();
            
            q.offer(i);
            visit[i] = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                
                for (int j = 0; j < size; j++) {
                    int curr = q.poll();
                    
                    for (int next: graph[curr]) {
                        
                        if (visit[next] != 0) {
                            if (visit[next] == visit[curr]) return false;
                            else continue;
                        } 
                        
                        q.offer(next);
                        visit[next] = visit[curr] == 1 ? 2 : 1;
                    }
                }
            }
        }
        
        return true;
    }
}