// 611. Valid Triangle Number

public class Solution {
    public int triangleNumber(int[] nums) {
        
        int i, j, k;  // Index of each side in nums
        int count = 0;
        int len = nums.length;
        
        Arrays.sort(nums);  // Sort the array
        
        // O(n^2)
        for(i = 0; i < len - 2; i++) {
            // Skip invalid value
            if (nums[i] == 0) {
                continue;
            }
            
            k = i + 2;
            
            for(j = i + 1; j < len - 1; j++) {
                // k is not re-initialized when j changes
                while (k < len && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                // Avoid wrong count when k = len, j = len - 1
                count += k - j - 1;
            }
        }
        
        return count;
    }
}
