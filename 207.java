class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> edge = new ArrayList<>();
        boolean[] visit = new boolean[numCourses];
        
        // init 
        for (int i = 0; i < numCourses; i++) {
            edge.add(new HashSet<Integer>());
        }
        
        // convert
        for (int[] p: prerequisites) {
            edge.get(p[1]).add(p[0]);
        }
        
        // topological sort
        // since we iterate from 0, it's important to add CRITICAL part
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == false && hasCycle(edge, visit, i)) 
                return false;
        }
        
        return true;
    }
    
    
    public boolean hasCycle(List<Set<Integer>> e, boolean[] v, int i) {
        if (v[i]) return true;
        
        v[i] = true;
        for (int next: e.get(i)) {
            if (hasCycle(e, v, next)) return true;
        }
        
        // CRITICAL
        v[i] = false;
        
        return false;
    }
}