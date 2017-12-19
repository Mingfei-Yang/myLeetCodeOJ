// 682. Baseball Game
// Stack
class Solution {
    public int calPoints(String[] ops) {
        /* Assuming that ops ONLY contains valid types */
        
        if (ops.length == 0) {
            return 0;
        }
        
        Stack<Integer> p_stack = new Stack();  // Points stack
        int sum = 0;  // Sum of Valid points
        int cur = 0;  // Score of Current round
        int last_1 = 0;  // Last round
        int last_2 = 0;  // Round before last_1
        
        for(String str : ops) {
            // Operation: C
            if (str.equals("C") && !p_stack.empty()) {
                cur = 0 - p_stack.pop();
            }
            // Scores: D or + or Points 
            else {
                // D
                if (str.equals("D") && !p_stack.empty()) {
                    cur = p_stack.peek() * 2;
                }
                // +
                else if (str.equals("+") && !p_stack.empty()) {
                    last_1 = p_stack.pop();
                    last_2 = p_stack.peek();
                    cur = last_1 + last_2;
                    // Push back
                    p_stack.push(last_1);
                }
                // Points
                else {
                    cur = Integer.valueOf(str);
                }
                // Push current score
                p_stack.push(cur);
            }
            // Update Sum
            sum += cur;
        }
        
        return sum;
    }
}
