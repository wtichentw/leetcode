class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int goal = stones[stones.length - 1];
        
        for (int i = 0; i < stones.length - 1; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(1);
        
        for (int i = 0; i < stones.length - 1; i++) {
            if (map.get(stones[i]) == null) continue;
            
            for (int v: map.get(stones[i])) {
                int next = stones[i] + v;

                if (next == goal) return true;
                if (next > goal || map.get(next) == null) continue;
                
                if (v != 0)     map.get(next).add(v);
                if (v + 1 != 0) map.get(next).add(v + 1);
                if (v - 1 != 0) map.get(next).add(v - 1);
            }
        }
        
        return false;   
    }
}