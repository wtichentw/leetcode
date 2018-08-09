class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        double[] ans = new double[queries.length];
        
        // convert edge data structure
        for (int i = 0; i < equations.length; i++) {
            
            // ignore self-loop edge
            if (equations[i][0].equals(equations[i][1])) continue;
            
            map.putIfAbsent(equations[i][0], new HashMap<String, Double>());
            map.putIfAbsent(equations[i][1], new HashMap<String, Double>());
            
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], (double) 1 / values[i]);
        }
               
        int idx = 0;
        for (String[] q: queries) {
            double res =  helper(map, q[0], q[1], 1.0, new HashSet<String>());
            
            ans[idx++] = res;
        }
        
        return ans;        
    }
    
    public double helper(Map<String, Map<String, Double>> map, String curr, String goal, double val, Set<String> set) {
        // make -1.0 not-found return value
        if (map.get(curr) == null) return -1.0;
        if (set.contains(curr)) return -1.0;
        if (curr.equals(goal)) return val;
        
        set.add(curr);
        for (String next: map.get(curr).keySet()) {
            double factor = map.get(curr).get(next);
            double res = helper(map, next, goal, val * factor, set);
            
            if (res != -1.0) return res;
        }
        set.remove(curr);
        
        return -1.0;
    }
}