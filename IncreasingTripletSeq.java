// 334. Increasing Triplet Sequence

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int len = nums.length;
        
        if (len < 3) {
            return false;
        }
        
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        
        // Linear traversal, O(n)
        for(int n : nums) {
            // If n <= minimum, then min = n
            if (n <= min) {
                min = n;
            }
            // If n > min && n <= middle, then mid = n 
            else if (n <= mid) {
                mid = n;
            }
            else {
                return true;
            }
        }
        
        return false;
    }
}
