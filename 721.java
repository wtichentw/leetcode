class Solution {
    public List<List<String>> accountsMerge(List<List<String>> acts) {
        List<List<String>> res = new ArrayList<>();
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        
        // init
        for (List<String> a: acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        
        // uf
        for (List<String> a: acts) {
            String pFirst = find(a.get(1), parents);
            
            for (int i = 2; i < a.size(); i++) {
                String pRest = find(a.get(i), parents);
                
                parents.put(pRest, pFirst);
            }
        }
        
        // aggregate
        for(List<String> a: acts) {
            String p = find(a.get(1), parents);
            
            if (!unions.containsKey(p)) 
                unions.put(p, new TreeSet<>());
            
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        
        // convert
        for (String p: unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            
            emails.add(0, owner.get(p));
            
            res.add(emails);
        }
        
        return res;
    }
    
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s? s: find(p.get(s), p);
    }
}