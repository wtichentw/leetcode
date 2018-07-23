class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (String str: strings) {
            String key = getKey(str);
            
            if (map.get(key) == null) {
                ans.add(new ArrayList<String>());
                map.put(key, ans.size() - 1);
            }
            
            int idx = map.get(key);
            ans.get(idx).add(str);
        }
        
        return ans;
    }
    
    public String getKey(String str) {
        char[] arr = str.toCharArray();
        char pivot = arr[0];
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pivot)
                arr[i] = (char) (arr[i] - pivot + 26);
            else 
                arr[i] = (char) (arr[i] - pivot);
        }
        
        return new String(arr);
    }
}