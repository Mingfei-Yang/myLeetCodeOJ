// 15. 3Sum
// O(n^2)

class Solution {
    
    // Define a final result
    private int finalResult = 0;
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        // Result List
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort the input array first
        Arrays.sort(nums);
        
        // Check every possible choice of the first element
        // From nums[0] to nums[nums.length - 2]
        for (int i = 0; i < nums.length - 2; i++) {
            // So the first element is nums[i]
            // Prevent duplicate choices of first element
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                // Problem reduced to 2Ssum
                int left = i + 1;  // Left pointer for remaining part of the array
                int right = nums.length - 1;  // Right pointer for the remaining part of the array
                int target = finalResult - nums[i];  // Target for 2Sum
                // Find the 2Sum with 2 pointers, because nums has been sorted
                while (left < right) {
                    // 2Sum found
                    if (nums[left] + nums[right] == target) {
                        // Temp List for current triplet
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);  // First element
                        temp.add(nums[left]);  // Second element
                        temp.add(nums[right]);  // Third element
                        // Add to result list
                        result.add(temp);
                        
                        // Eliminate possible duplicate numbers
                        // For Left pointer
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }  // End Inner-while
                        // For Right pointer
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }  // End Inner-while
                        left++;
                        right--;
                    } // End Inner-if
                    // If Sum is less than target
                    else if (nums[left] + nums[right] < target) {
                        left++;
                    }
                    // If Sum is greater than target
                    else {
                        right--;
                    }
                }  // End Outer-while 
            }  // End if
        } // End for-loop
        
        return result;
    }
}
