class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Set<Integer>> edge = new HashMap<>(); // passing buses of stop
        Set<Integer> set = new HashSet<>(); 
        int ans = 0;

        // convert
        for (int r = 0; r < routes.length; r++) {
            for (int i = 0; i < routes[r].length; i++) {
                if (edge.get(routes[r][i]) == null) edge.put(routes[r][i], new HashSet<Integer>());
                edge.get(routes[r][i]).add(r);                
            }
        }

        // bfs
        q.offer(S);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                if (curr == T) return ans;
        
                for (int bus: edge.get(curr)) {
                    if (set.contains(bus)) continue;
                    
                    set.add(bus);
                    
                    for (int next: routes[bus]) 
                        q.offer(next);
                }
            }

            ans++;
        }

        return -1;
    }
}