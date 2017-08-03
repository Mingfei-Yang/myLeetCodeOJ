// 47. Permutations - II
// Backtracking

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> p = new ArrayList<Integer>();
        // Flag array to indicate whether the element has been used
        boolean[] flags = new boolean[nums.length];
        
        // Call backtracking func
        /* Args: original array, flag array, current permutation list, result list */
        backTracking(nums, flags, p, result);
        
        return result;
    }
    
    /* Args: original array, flag array, current permutation list, result list */
    private void backTracking(int[] nums, boolean[] flags, List<Integer> p, List<List<Integer>> r) {
        if (p.size() == nums.length) {
            r.add(new ArrayList<Integer>(p));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            // Skip used elements or used duplicates
            if (flags[i] || (i > 0 && nums[i] == nums[i - 1] && !flags[i - 1]) ) {
                continue;
            }
            
            p.add(nums[i]);
            flags[i] = true;  // Mark the added element as used
            
            backTracking(nums, flags, p, r);  // Call backtracking func
            
            flags[i] = false;  // Resume the status of current element
            p.remove(p.size() - 1);  // Remove most recently added element
        }
    }
}
