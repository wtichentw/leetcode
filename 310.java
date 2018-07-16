class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] E) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> edge = new ArrayList<>();
        List<Integer> leave = new ArrayList<>();
        
        // init
        for (int i = 0; i < n; i++) {
            edge.add(new HashSet<Integer>());
        }
        
        // convert edges to faster ds
        for (int[] e: E) {
            int u = e[0], v = e[1];
            
            edge.get(u).add(v);
            edge.get(v).add(u);
        }        
        
        // get 1st level leave
        for (int i = 0; i < edge.size(); i++) {
            if (edge.get(i).size() == 1) leave.add(i);
        }
        
        // remove leaves circlely
        while (n > 2) {
            List<Integer> newleave = new ArrayList<>();
            n -= leave.size();
            
            for (int curr: leave) {
                for (int next: edge.get(curr)) {
                    edge.get(next).remove(curr);
                    edge.get(curr).remove(next);
                    
                    if (edge.get(next).size() == 1) newleave.add(next);
                }
            }
            
            leave = newleave;
        }
        
        return leave;
    }
}