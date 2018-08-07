class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < asteroids.length;) {
            // positive 
            if (asteroids[i] > 0) {
                s.push(asteroids[i]);
                i++;
            }
            
            // negative and have collision
            else if (!s.isEmpty()) {
                if (Math.abs(asteroids[i]) < s.peek()) {
                    i++;
                }
                else if (Math.abs(asteroids[i]) == s.peek()) {
                    s.pop();
                    i++;
                }
                else {
                    s.pop();
                }
            }
            
            // no collision
            else {
                neg.add(asteroids[i]);
                i++;
            }
        }
        
        // reverse
        while (!s.isEmpty()) pos.add(0, s.pop());
        
        // add
        int[] ans = new int[pos.size() + neg.size()];
        int idx = 0; 
        for (int n: neg) ans[idx++] = n;
        for (int p: pos) ans[idx++] = p;
        
        return ans;
    }
}