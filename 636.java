class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs.size() <= 1) return null;
        
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];  
        int ptime = 0;    
        
        for (int i = 0; i < logs.size(); i++) {
            String[] split = logs.get(i).split(":");
            
            int id = Integer.parseInt(split[0]);
            int ctime = Integer.parseInt(split[2]);
            boolean start = split[1].equals("start");
            
            if (start) {
                if (!stack.isEmpty())
                    ans[stack.peek()] += ctime - ptime;
                
                // always save
                stack.push(id);
                ptime = ctime;
            } 
            else {
                ans[stack.pop()] += ctime - ptime + 1;
                ptime = ctime + 1;
            }
        }
        
        return ans;
    }
}