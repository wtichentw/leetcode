class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            String key1 = e1.getKey(), key2 = e2.getKey();
            int cnt1 = e1.getValue(), cnt2 = e2.getValue();
            
            return cnt1 == cnt2? key1.compareTo(key2): (cnt1 - cnt2) * -1;
        });
        List<String> ans = new LinkedList<>();
        
        // calculate frequency of word
        for (String str: words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        // use pq to get top k
        pq.addAll(map.entrySet());
        while (k-- > 0) {
            ans.add(pq.poll().getKey());
        }
        
        // return ans
        return ans;
    }
}