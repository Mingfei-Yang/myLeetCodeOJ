// 496. Next Greater Element - I

public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        
        Map<Integer, Integer> map = new HashMap();  // Map for each element and its next greater element
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int n : nums) {
            // pop the elements that the next greater element is n
            // and put them into Map
            while (!stack.isEmpty() && stack.peek() < n) {
                map.put(stack.pop(), n);
            }
            
            stack.push(n);
        }
        
        // Check the Map
        for(int i = 0; i < findNums.length; i++) {
            findNums[i] = map.getOrDefault(findNums[i], -1);
        }
        
        return findNums;
    }
}
