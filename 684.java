class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int[] e: edges) {
            // if there are multiple answers, return the answer that occurs last in the given 2D-array.
            // since having this rule, we iterate and DFS
            // checking if there's already a path
            if (hasPath(e[0], e[1], graph, new HashSet<Integer>())) 
                return e;
            
            // new path can add to graph
            if (graph.get(e[0]) == null) 
                graph.put(e[0], new HashSet<Integer>());
            
            if (graph.get(e[1]) == null) 
                graph.put(e[1], new HashSet<Integer>());
            
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        return null;
    }
    
    public boolean hasPath(int curr, int goal, Map<Integer, Set<Integer>> graph, Set<Integer> visit) {
        if (graph.get(curr) == null || visit.contains(curr)) 
            return false;
        if (curr == goal)
            return true;
        
        visit.add(curr);
        for (int next: graph.get(curr)) {
            if (hasPath(next, goal, graph, visit)) 
                return true;
        }
        
        return false;
    }
}