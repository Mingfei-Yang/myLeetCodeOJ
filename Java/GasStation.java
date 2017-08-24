// 134. Gas Station
// Greedy

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        if (gas.length != cost.length) {
            return -1;
        }
        
        int gasLeft = 0; // Gas left in tank
        int len = gas.length;
        int i = 0;
        int index;  // Index of the gas array
        int start = -1;  // Starting point (return value)
        
        // Maximum iteration time is 2 * gas.length - 1
        // i.e. from the last element back to the front,
        // and then to the second last element
        while (i <= len + start) {
            index = i % len;  // Current index of the gas array
            
            // If gas in total is great or equal than cost
            if (gas[index] + gasLeft >= cost[index]) {
                
                // If starting point is -1, set to index
                if (start == -1) {
                    start = index;
                }
                gasLeft = gas[index] + gasLeft - cost[index];
            }
            // When gas left is insufficient
            else {
                // If start had been set, then reset it to initial value
                if (start != -1) {
                    start = -1;
                    gasLeft = 0;
                }
            }
            
            i++;
        }
        
        return start;
    }
}
