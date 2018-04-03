// 322. Coin Change
// Dynamic Programming

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // illegal parameters
        if (amount == 0) {
            return 0;
        }
        
        if (coins.length < 1) {
            return -1;
        }
        
        // a 2D matrix is used to store incremental solutions
        // row is amount, column is the minimum coins needed for that amount
        
        // Result "Matrix" - Basically a single List, because we only have one column.
        List<Integer> matrix = new ArrayList<>();
        
        // Sort the value of coins.
        Arrays.sort(coins);
        
        matrix.add(0);  // For the amount of 0
        
        // Construct the Result "Matrix" incrementally from 1 to amount
        // O(coins.length * amount) 
        for (int a = 1; a <= amount; a++) {
            // if current amount a is less than minimum coin value
            // Add 0 to current amount a, and continue to next amount.
            if (a < coins[0]) {
                matrix.add(0);
                continue;
            }
            
            // List for all possible solutions for current amount a
            List<Integer> tempSolution = new ArrayList<Integer>();
            // For every coin value we have
            for (int value : coins) {                
                // If the current coin value == current amount a
                if (a == value) {
                    // Only 1 coin needed for this amount, break the inner loop
                    tempSolution.add(1);
                    break;
                }
                // Else if the current coin value > current amount a
                else if (a > value) {
                    // Get the Minimum coins needed for the amount of (a - coins[i])
                    // If the minumum amount is not 0
                    // Then add 1 to it and append to tempSolution
                    if (matrix.get(a - value) > 0)
                        tempSolution.add(matrix.get(a - value) + 1);
                    else
                        tempSolution.add(0);
                }
                // Else the current coin value < current amount
                else {
                    // break inner loop
                    break;
                }       
            }  // Inner For-loop
            
            // If tempSolution is not empty
            if (!tempSolution.isEmpty()) {
                // Add the minimum Non-zero solution in tempSolution to result matrix
                // Otherwise append 0
                Collections.sort(tempSolution);
                
                // Flag for Adding minimum solution
                boolean flag = false;
                
                for (int t : tempSolution) {
                    if (t != 0) {
                        matrix.add(t);
                        flag = true;  // Adding completed
                        break;
                    }
                }
                
                // If all solution is 0, add 0
                if (!flag)
                    matrix.add(tempSolution.get(0));
            }
        } // Outer For-loop
        
        // Get the result at index 'amount'
        return matrix.get(amount) == 0 ? -1 : matrix.get(amount); 
        
    }
}
