class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        int i = 1;
        
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            
            int cnt = 1;
            char chr = ans.charAt(0);
            
            for (int j = 1; j < ans.length(); j++) {
                if (ans.charAt(j) == ans.charAt(j - 1)) {
                    cnt++;
                }
                else {
                    sb.append(cnt);
                    sb.append(chr);
                    
                    cnt = 1;
                    chr = ans.charAt(j);
                }
            }
            
            sb.append(cnt);
            sb.append(chr);
            
            ans = sb.toString();
            i++;
        }
        
        return ans;
    }
}