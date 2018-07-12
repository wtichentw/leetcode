class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>();
        int ans = 0;
        
        // convert
        for (String s: wordList) dict.add(s);
        
        // bfs
        queue.offer(begin);
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                if (curr.equals(end)) return ans + 1;
                
                for (int j = 0; j < curr.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (curr.charAt(j) == k) continue;
                        
                        String next = curr.substring(0, j) + k + curr.substring(j + 1);
                        
                        if (dict.contains(next)) {
                            queue.offer(next);
                            dict.remove(next);
                        }
                    }
                }
            }
            
            ans++;
        }
        
        return 0;
    }
}