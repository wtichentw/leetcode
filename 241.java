class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        // terminal
        if (input.indexOf('+') == -1 && input.indexOf('-') == -1 && input.indexOf('*') == -1) 
            return Collections.singletonList(Integer.valueOf(input));
        
        
        List<Integer> ans = new ArrayList<>();
        int n = input.length();
        
        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            
            if (c == '+' || c == '-' || c == '*') {
                String sub1 = input.substring(0, i);
                String sub2 = input.substring(i + 1, n);
                
                List<Integer> l1 = diffWaysToCompute(sub1);
                List<Integer> l2 = diffWaysToCompute(sub2);
                
                for (int i1: l1) {
                    for (int i2: l2) {
                        if (c == '+') ans.add(i1 + i2);
                        if (c == '-') ans.add(i1 - i2);
                        if (c == '*') ans.add(i1 * i2);
                    }
                }
            }
        }
        
        return ans;
    }
}