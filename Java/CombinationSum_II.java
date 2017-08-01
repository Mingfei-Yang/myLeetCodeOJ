// 40. Combination Sum II
// Backtracking

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);  // Sort the array to make duplicates in sequence
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        List<Integer> combination = new ArrayList<Integer>();
        
        // Call backtracking func
        /* Args: candidates array, target sum, combination list, result list */
        backTracking(candidates, target, 0, combination, result);
        
        return result;
    }
    
    private void backTracking(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        
        if (target < 0) {
            return;
        }
        // If target is met, then add the current combination
        if (target == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            // Skip duplicate elements
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            backTracking(candidates, target - candidates[i], i + 1, combination, result);
            combination.remove(combination.size() - 1);  // Remove the most recently added element
        }
    }
}
