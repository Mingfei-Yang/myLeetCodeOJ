// 456. 132 Pattern
// Using Stack & a Min array

class Solution {
    public boolean find132pattern(int[] nums) {
        
        int len = nums.length;
        
        if (len < 3) {
            return false;
        }
        
        // Step 1 - Build a min array
        /** e.g. 
         * for [3, 1, 4, 2]
         * the min array is [3, 1, 1, 1]
         * for [6, 12, 3, 4, 6, 11, 20]
         * the min array is [6, 6, 3, 3, 3, 3, 3]
         */
        int[] min = new int [len];
        int m = nums[0];
        
        for(int i = 0; i < len; i++) {
            if (m > nums[i]) {
                m = nums[i];
            }
            
            min[i] = m;
        }
        
        // Step 2 - Traverse nums & min in reverse order
        Stack<Integer> stack = new Stack<Integer>();
        int i;
        for(i = len - 1; i >= 0; i--) {
            // If nums[i] > min[i]
            if (nums[i] > min[i]) {
                // If stack.peek() <= min[i], pop
                while (!stack.isEmpty() && stack.peek() <= min[i]) {
                    stack.pop();
                }
                // If stack.peek() < nums[i], then we've found 132 pattern
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                
                stack.push(nums[i]);  // Push element
            }
        }
        
        return false;        
    }
}
