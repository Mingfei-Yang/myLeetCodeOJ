// 503. Next Greater Element - II

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int[] result = new int [nums.length];
        Stack<Integer> stack = new Stack<Integer>();    // Stack is used to store indices
        int index;
        
        // Traverse the array twice
        for(int i = 2 * nums.length - 1; i >= 0; i--) {
            index = i % nums.length;
            
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[index]) {
                stack.pop();
            }
            
            // If stack is empty, then -1, else the nums[top of stack]
            result[index] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(index);  // Push the index back
        }
        
        return result;
    }
}
