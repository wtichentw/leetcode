class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> curr = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();
        
        curr.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prev = curr;
            curr = new HashMap<Integer, Integer>();
            
            for (Map.Entry<Integer, Integer> e: prev.entrySet()) {
                int prevVal = e.getKey(), prevCnt = e.getValue();
                int nextValPos = prevVal + nums[i], nextValNeg = prevVal - nums[i];
                
                if (curr.get(nextValPos) != null)
                    curr.put(nextValPos, curr.get(nextValPos) + prevCnt);
                else
                    curr.put(nextValPos, prevCnt);
                
                if (curr.get(nextValNeg) != null)
                    curr.put(nextValNeg, curr.get(nextValNeg) + prevCnt);
                else
                    curr.put(nextValNeg, prevCnt);
                
            }
        }
        
        return curr.get(S) == null? 0: curr.get(S);    
    }
}