public class Solution {
    public int leastInterval(char[] tasks, int n) {
        // char map
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        
        // insert to pq
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f: map) {
            if (f > 0) pq.add(f);
        }
        
        // building
        int time = 0;
        while (!pq.isEmpty()) {
            int i = 0;
            List<Integer> notdone = new ArrayList<>();
            
            // at most n task for a interval
            // increment until i == n
            while (i <= n) { 
                if (!pq.isEmpty()) {
                    // not all executed
                    if (pq.peek() > 1) notdone.add(pq.poll() - 1);
                    
                    // all executed
                    else pq.poll();
                }
                
                i++;
                time++;
                
                // complete early in last interval
                if (pq.isEmpty() && notdone.size() == 0) break;
            }
            
            // re-insert
            for (int l: notdone) pq.add(l);
        }
        
        return time;
    }
}
