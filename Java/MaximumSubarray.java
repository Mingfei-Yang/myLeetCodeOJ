// 53. Maximum Subarray
// Dynamic Programming
class Solution {
    public int maxSubArray(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }
        
        int tempSum = 0;  // Current sum
        int maxSum = nums[0];  // Max sum
        
        for(int n : nums) {
            // If (previous sum + current number n) is less than (n)
            // Use the (n) as the new current sum
            // Else Use the (previous sum + n) as new current sum
            tempSum = (tempSum + n) > n ? (tempSum + n) : n;
            
            // Update maxSum accordingly
            if (tempSum > maxSum) {
                maxSum = tempSum;
            }
        }
        
        return maxSum;
    }
}
