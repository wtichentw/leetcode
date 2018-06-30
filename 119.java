class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        
        for (int i = 0; i <= rowIndex; i++) {
            prev = curr;
            curr = new ArrayList<Integer>();
            
            if (i == 0) {
                curr.add(1);
            }            
            else {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        curr.add(1);
                    }
                    else {
                        curr.add(prev.get(j) + prev.get(j - 1));
                    }
                }
            }
        }
        
        return curr;
    }
}
