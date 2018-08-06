class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int i = 0, n = heights.length, ans = 0;
        
        while (i < n) {
            // only push when bigger
            if (s.isEmpty() || heights[i] > heights[s.peek()]) {
                s.push(i);
                i++;
            }
            
            // if smaller, calculate area before i (exclusive)
            else {
                int h = heights[s.pop()];
                int w = s.isEmpty()? i: i - 1 - s.peek();
                
                ans = Math.max(ans, h * w);
            }
        }
        
        // last round
        while (!s.isEmpty()) {
            int h = heights[s.pop()];
            int w = s.isEmpty()? i: i - 1 - s.peek();

            ans = Math.max(ans, h * w);
        }
        
        return ans;
    }
}