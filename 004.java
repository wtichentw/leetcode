class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }   
        
        int n1 = nums1.length, n2 = nums2.length, n3 = n1 + n2;
        
        // cut1: #elements on the left side of the cut for nums1
        // cut2: #elements on the left side of the cut for nums2 
        int cut1 = 0, cut2 = 0;
        int cutL = 0, cutR = n1 - 1;
        
        // go as far as n1
        while (cut1 <= n1) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = n3 / 2 - cut1;
            
            double L1 = (cut1 == 0)? Integer.MIN_VALUE: nums1[cut1 - 1];
            double L2 = (cut2 == 0)? Integer.MIN_VALUE: nums2[cut2 - 1];
            double R1 = (cut1 == n1)? Integer.MAX_VALUE: nums1[cut1];
            double R2 = (cut2 == n2)? Integer.MAX_VALUE: nums2[cut2];
            
            if (L1 > R2) {
                cutR = cut1 - 1;
            }
            else if (L2 > R1) {
                cutL = cut1 + 1;
            }
            else {
                if (n3 % 2 == 0) {
                    double L = L1 > L2? L1: L2;
                    double R = R1 < R2? R1: R2;
                    return (L + R) / 2;
                }
                else {
                    return R1 < R2? R1: R2;
                }
            }
        }
        
        return -1;
    }
}