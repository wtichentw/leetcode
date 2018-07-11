class Solution {
    public int trap(int[] A) {
        // left, right is walking index
        // maxleft, maxright is max height found so far
        int left = 0, right = A.length - 1;
        int maxleft = 0, maxright = 0;
        int ans = 0;
    
        // could also be < or <= since equal would do nothing
        while (left < right) {
            
            // shorter side need to be shrinked
            // could be < or <=, doesn't matter which side to shrink it equal
            System.out.println(left + " " + right);
            
            if (A[left] < A[right]) {
            
                // updating 
                // could also be > or >= since equal would do nothing
                if (A[left] > maxleft) maxleft = A[left];
                
                // descending, add gap 
                else {
                    System.out.println("Add " + (maxleft - A[left]));
                    ans += maxleft - A[left];
                }
                    
                left++;
            }
            else {
                if (A[right] > maxright) maxright = A[right];
                else {
                    System.out.println("Add " + (maxright - A[right]));
                    ans += maxright - A[right];
                }
                
                right--;
            }
        }
            
        return ans;
    }
}