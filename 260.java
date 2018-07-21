class Solution {
    public int[] singleNumber(int[] nums) {
        int a = 0, b = 0, ab = 0, diff = 1;
        
        for (int n: nums) 
            ab ^= n;
        
        // find diff bit of a and b
        // which only a or b have that bit
        while ((ab & diff) == 0) 
            diff <<= 1;
        
        // since pair num will be elimainated
        // ^= accord to diff bit
        for (int n: nums) {
            if ((n & diff) == 0)
                a ^= n;
            else 
                b ^= n;
        }
                
        return new int[] {a, b};
    }
}