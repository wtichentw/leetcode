class Solution {
    String[][] table = new String[][] {
            {""}, // 0
            {""}, // 1
            {"a", "b", "c"}, // 2
            {"d", "e", "f"}, // 3
            {"g", "h", "i"}, // 4
            {"j", "k", "l"}, // 5
            {"m", "n", "o"}, // 6
            {"p", "q", "r", "s"}, // 7
            {"t", "u", "v"}, // 8
            {"w", "x", "y", "z"}, // 9
    };
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        
        List<String> ans = new ArrayList<>();
        
        backtrack(digits, ans, new StringBuilder(), 0);
        
        return ans;
    }
    
    public void backtrack(String digits, List<String> ans, StringBuilder sb, int idx) {
        if (idx == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        
        for (String alpha: table[digits.charAt(idx) - '0']) {
            sb.append(alpha);
            backtrack(digits, ans, sb, idx + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}