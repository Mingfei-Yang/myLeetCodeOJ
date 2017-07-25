// 78. Subsets
// Backtracking
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        // Result list
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);  // Sort the array
        
        // Call backtracking function
        backTrack(result, new ArrayList<Integer>(), nums, 0);
        
        return result;
    }
    
    private void backTrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
        // Add current temp list
        list.add(new ArrayList<>(temp));
        
        for(int i = start; i < nums.length; i++) {
            temp.add(nums[i]);  // Add current element
            backTrack(list, temp, nums, i + 1); // Call backtracking function
            temp.remove(temp.size() - 1);   // Remove the most recently added element
        }
    }
}
