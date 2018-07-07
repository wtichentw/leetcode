class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] h = new int[] {8, 4, 2, 1};
        int[] m = new int[] {32, 16, 8, 4, 2, 1};
        
        List<String> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i <= num; i++) {
            List<Integer> h2 = new ArrayList<>();
            List<Integer> m2 = new ArrayList<>();
            helper(h2, h, i, 0, 0);
            helper(m2, m, num - i, 0, 0);
            
            for (int hi : h2) {
                for (int mi: m2) {
                    if (hi >= 12 || mi >= 60) continue;
                    
                    String hstr = Integer.toString(hi);
                    String mstr = mi < 10? "0" + Integer.toString(mi): Integer.toString(mi);
                    
                    ans.add(hstr + ":" + mstr);
                }
            }
        }
        
        return ans;
    }
    
    public void helper(List<Integer> ls, int[] arr, int cnt, int idx, int sum) {
        if (cnt == 0) {
            ls.add(sum);
            return;
        }
        
        for (int i = idx; i < arr.length; i++) {
            helper(ls, arr, cnt - 1, i + 1, sum + arr[i]);
        }
    }
    
    public String convert(int sum) {
        String h = Integer.toString(sum / 60);
        String m = Integer.toString(sum % 60);
        
        // if (h.length() == 1 && h.charAt(0) != '0') h = "0" + h;
        if (m.length() == 1) m = "0" + m;
        
        return h + ":" + m;
    }
}