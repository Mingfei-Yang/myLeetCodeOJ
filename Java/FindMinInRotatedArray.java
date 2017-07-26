// 153. Find Minimum in Rotated Array
// Using Binary Search

public class Solution {
    public int findMin(int[] nums) {
        
        int len = nums.length;
        
        if (len == 1) {
            return nums[0];
        }
        
        int start = 0;
        int end = len - 1;
        int mid;
        
        // If rotated to non-ascending order (rotateRange % nums.length != 0)
        // nums[start] must be greater than nums[end]
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        
        int min = nums[end];  // Set current min to nums[end]
        
        while (start < end) {
            mid = start + (end - start) / 2;
            
            if (nums[mid] > min) {
                start = mid + 1;
            }
            else {
                min = nums[mid];  // Get new min value
                end = mid;
            }
        }
        
        return min;
    }
}
