// 561. Array Partition I

public class Solution {
    public int arrayPairSum(int[] nums) {
        
        int result = 0;
        int len = nums.length;
        
        if (len == 0) {
            return 0;
        }
        
        // Sort the array, then the max result will be easy to calculate
        Arrays.sort(nums);
        
        // Add up the first element of each pair
        for(int i = 0; i < len; i += 2) {
            result += nums[i];
        }
        
        return result;
    }
}
