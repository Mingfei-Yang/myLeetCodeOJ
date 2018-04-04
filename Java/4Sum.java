// 18. 4Sum
// Reducing it to 3Sum

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Result List
        List<List<Integer>> result = new ArrayList<>();
        
        // check nums
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        // Sort the input array first
        Arrays.sort(nums);
    
        int e1;  // First element chosen
        // Check every possible choice of first element of 4Sum
        for (int i = 0; i < nums.length - 3; i++) {
            e1 = nums[i];
            /* Elimination conditions */
            // Eliminate duplicates
            if (i > 0 && e1 == nums[i - 1]) {
                continue;
            }
            // e1 too large
            if (e1 * 4 > target) {
                break;
            }
            // e1 too small
            if (e1 + 3 * nums[nums.length - 1] < target) {
                continue;
            }
            // for boundary case
            if (e1 * 4 == target && e1 == nums[i + 3]) {
                result.add(Arrays.asList(e1, e1, e1, e1));
                break;
            }
            
            // Reduce the problem to 3Sum, with e1 selected
            threeSum(nums, target - e1, result, i + 1, e1);
        }

        return result;
    }
    
    // 3Sum
    public void threeSum(int[] nums, int finalResult, List<List<Integer>> result, int start, int e1) {
        
        // Check every possible choice of the first element of 3Sum
        // From nums[start] to nums[nums.length - 3]
        for (int i = start; i < nums.length - 2; i++) {
            // So the first element is nums[i]
            // Prevent duplicate choices of first element
            if (i == start || (i > 0 && nums[i] != nums[i-1])) {
                // Problem reduced to 2Ssum
                int left = i + 1;  // Left pointer for remaining part of the array
                int right = nums.length - 1;  // Right pointer for the remaining part of the array
                int target2Sum = finalResult - nums[i];  // Target for 2Sum
                // Find the 2Sum with 2 pointers, because nums has been sorted
                while (left < right) {
                    // 2Sum found
                    if (nums[left] + nums[right] == target2Sum) {
                        // Add to result list
                        result.add(Arrays.asList(e1, nums[i], nums[left], nums[right]));
                        
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
                    // If Sum is less than target2Sum
                    else if (nums[left] + nums[right] < target2Sum) {
                        left++;
                    }
                    // If Sum is greater than target2Sum
                    else {
                        right--;
                    }
                }  // End Outer-while 
            }  // End if
        } // End for-loop
    }
}
