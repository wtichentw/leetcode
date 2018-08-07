class Solution {
    public String parseTernary(String s) {
        Stack<String> stack = new Stack<>();
      
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek().equals("?")) {
                
                stack.pop(); // ?
                String first = stack.pop();
                stack.pop(); // :
                String second = stack.pop();
                
                if (s.charAt(i) == 'T') 
                    stack.push(first);
                else 
                    stack.push(second);
            }
            else {
                stack.push(s.substring(i, i+ 1));
            }
        }    
                
        return stack.pop();
    }
}