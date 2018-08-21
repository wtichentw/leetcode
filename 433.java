class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> s = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        List<String> l = Arrays.asList("A", "C", "G", "T");
        int ans = 1;
        
        for (String b: bank) {
            s.add(b);
        }
        
        q.offer(start);
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        String next = curr.substring(0, j) + l.get(k) + curr.substring(j + 1);
                        
                        if (!s.contains(next)) continue;
                        if (next.equals(curr)) continue;
                        if (next.equals(end)) return ans;
                        
                        q.offer(next);
                        s.remove(next);
                    }
                }
            }
            
            ans += 1;
        }
        
        return -1;
    }
}