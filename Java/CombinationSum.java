// 39. Combination Sum
// Backtracking

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        List<Integer> combination = new ArrayList<Integer>();
        
        // Call backtracking func
        /* Args: candidates array, target sum, array element position, combination list, result list */
        backTracking(candidates, target, 0, combination, result);
        
        return result;
    }
    
    /* Args: candidates array, target sum, array element position, combination list, result list */
    private void backTracking(int[] candidates, int target, int start, List<Integer> c, List<List<Integer>> r) {
        
        if (target < 0) {
            return;
        }
        // If target is met, add current combination in result list
        if (target == 0) {
            r.add(new ArrayList<Integer>(c));
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            c.add(candidates[i]);
            backTracking(candidates, target - candidates[i], i, c, r);
            c.remove(c.size() - 1);  // Remove the most recently added element
        }
    }
}
