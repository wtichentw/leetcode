class Solution {
    class Object {
        int key;
        int cnt;
        
        Object(int k, int c) {
            this.key = k;
            this.cnt = c;
        }
    }
    
    class ObjectComparator implements Comparator<Object> {
        @Override 
        public int compare(Object a, Object b) {
            return a.cnt > b.cnt? -1: 1;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Object> pq = new PriorityQueue<>(1, new ObjectComparator());
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) 
                map.put(nums[i], 1);
            else 
                map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            pq.offer(new Object(e.getKey(), e.getValue()));
        }
        
        while (k > 0) {
            ans.add(pq.poll().key);
            k--;
        }
        
        return ans;
    }
}