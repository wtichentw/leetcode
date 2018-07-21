class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (String str: strs) {
            String key = sort(str);
            
            if (map.get(key) == null) {
                ans.add(new ArrayList<String>());
                map.put(key, ans.size() - 1);
            }    
                
            int idx = map.get(key);
            ans.get(idx).add(str);
        }
        
        return ans;
    }
    
    public String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}