class Solution {
    int ans = 0;
    
    public int countArrangement(int N) {
        Set<Integer> set = new HashSet<>();
        
        helper(1, N, set);
        
        return ans;
    }
    
    public void helper(int idx, int N, Set<Integer> set) {
        if (idx == N + 1) {
            ans += 1;
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (idx % i != 0 && i % idx != 0) continue;
            if (set.contains(i)) continue;
            
            set.add(i);
            helper(idx + 1, N, set);
            set.remove(i);
        }
    }
}