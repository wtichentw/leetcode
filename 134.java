class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        // calculate profit
        for (int i = 0; i < n; i++) 
            gas[i] = gas[i] - cost[i];
        
        // try start at different stations
        for (int i = 0; i < n; i++) {
            int sum = 0;
            
            // at least pass n stataions
            for (int j = 0; j < n; j++) {
                sum += gas[(i + j) % n];
                if (sum < 0) break;
                if (j == n - 1) return i;                
            }
        }
            
        return -1;
    }
}