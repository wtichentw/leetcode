class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        List<Set<Integer>> edge = new ArrayList<>();
        int[] indegree = new int[n];
        int[] ans = new int[n];
        int idx = 0;
        
        // init 
        for (int i = 0; i < n; i++) {
            edge.add(new HashSet<Integer>());
        }
        
        // convert edge
        for (int[] p: prerequisites) {
            indegree[p[0]]++;
            edge.get(p[1]).add(p[0]);
        }
        
        // get 1st batch 
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        
        // bfs
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ans[idx++] = curr;
            
            for (int next: edge.get(curr)) {
                if (--indegree[next] == 0) 
                    queue.offer(next);
            }
        }

        return idx == n? ans: new int[0];    
    }
}