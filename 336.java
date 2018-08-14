class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length <= 1) return null;
        
        List<List<Integer>> ans = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        int n = words.length;
        
        // O(n)
        for (int i = 0; i < n; i++) {
            map.put(words[i], i);
        }
        
        // O(nk)
        for (int i = 0; i < n; i++) {
            // try every substring of words[i] here
            for (int j = 0; j <= words[i].length(); j++) {
                
                // divide string to A (str[0, j]) and B (str[j, str.length()])
                // if A is palindrome, we try to find reversed B in map
                String sub1 = words[i].substring(0, j);
                String sub2 = words[i].substring(j);
                String sub1r = new StringBuilder(sub1).reverse().toString();
                String sub2r = new StringBuilder(sub2).reverse().toString();
                
                
                // try to find if reversed substring from map
                if (isPalindrome(sub1)) {
                    if (map.get(sub2r) != null && map.get(sub2r) != i) {
                        ans.add(Arrays.asList(map.get(sub2r), i));
                    }
                }
                if (isPalindrome(sub2)) {
                    if (map.get(sub1r) != null && map.get(sub1r) != i && sub2.length() != 0) {
                        ans.add(Arrays.asList(i, map.get(sub1r)));
                    }
                }
            }
        }
        
        return ans;
    }
    
    public boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        
        return true;
    }
}