// 77. Combinations

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Call backtracking func
        backTracking(result, new ArrayList<Integer>(), n, k, 1);
        
        return result;
    }
    
    private void backTracking(List<List<Integer>> list, List<Integer> temp, int n, int k, int start) {
        // k represents the availability of adding element
        // start represents the element that will be added
        for(int i = start; i <= n && k != 0; i++) {
            temp.add(i);  // Add the element
            backTracking(list, temp, n, k - 1, i + 1);  // Call func with k - 1, i + 1
            temp.remove(temp.size() - 1);  // remove the most recently added element
        }
        
        if (k == 0) {
            list.add( new ArrayList<Integer>(temp) );
        }
    }
}
