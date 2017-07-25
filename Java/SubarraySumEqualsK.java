// 560. Subarray Sum Equals K
// Cumulative sum, O(n^2) + O(n)

public class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int len = nums.length;  // Length of nums
        int count = 0;
        int[] sums = new int [len + 1]; // cumulative sums
        
        sums[0] = 0;
        
        // Calculate sums, O(n)
        for(int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        
        // Check the sum, O(n^2)
        for(int s = 0; s < len; s++) {
            for(int e = s + 1; e <= len; e++) {
                // sums[e] - sums[s] == k then count++
                if (sums[e] - sums[s] == k) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
