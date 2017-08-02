// 46 Permutations
// Backtracking

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        List<Integer> p = new ArrayList<Integer>();
        
        // Call Backtracking func
        /* Args: original collection, permutation list, result list */
        backTracking(nums, p, result);
        
        return result;
    }
    
    private void backTracking(int[] nums, List<Integer> p, List<List<Integer>> result) {
        if (p.size() == nums.length) {
            result.add( new ArrayList<Integer>(p) );
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            // Avoid duplicates
            if ( p.contains(nums[i]) ) {
                continue;
            }
            
            p.add(nums[i]);
            backTracking(nums, p, result);
            p.remove( p.size() - 1 );  // Remove most recently added element
        }
    }
}
