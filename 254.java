class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new LinkedList<>();
        
        DFS(ans, new LinkedList<>(), n, 2);
            
        return ans;
    }
    
    public void DFS(List<List<Integer>> ans, List<Integer> cur, int num, int min) {
        if (num <= 1) {
            if (cur.size() >= 2) ans.add(new LinkedList<>(cur));
            
            return;
        }
        
        // must be i <= num since we use num <= 1 as terminal contidition
        for (int i = min; i <= num; i++) {
            if (num % i != 0) continue;
                
            cur.add(i);
            DFS(ans, cur, num / i, i);
            cur.remove(cur.size() - 1);
        }
    }
    
    public boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }   
        
        return true;
    }
}