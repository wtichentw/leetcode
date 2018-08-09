class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if (tokens[i].equals("-")) {
                int first = stack.pop();
                int second = stack.pop();
                
                stack.push(second - first);
            }
            else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if (tokens[i].equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                
                stack.push(second / first);
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return stack.pop();
    }
}