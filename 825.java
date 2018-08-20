class Solution {
    public int numFriendRequests(int[] ages) {
        // B is in range (0.5 * A + 7, A]
        int[] numInAge = new int[121];
        int[] sumInAge = new int[121];
        int res = 0;
                
        for(int i: ages) 
            numInAge[i]++;
        
        for(int i = 1; i <= 120; ++i) 
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];
        
        // because 0.5 * i + 7 >= i when i < 15.
        for(int i = 15; i <= 120; ++i) {
            if (numInAge[i] == 0) continue;
            
            int count = sumInAge[i] - sumInAge[i / 2 + 7];
            
            res += count * numInAge[i] - numInAge[i]; //people will not friend request themselves, so  - numInAge[i]
        }
        
        return res;
    }
}