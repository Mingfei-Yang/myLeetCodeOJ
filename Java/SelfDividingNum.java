// 728. Self Dividing Number
// Naive way
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        // Result list
        List<Integer> result = new ArrayList<Integer>();
        
        // Invalid Case, left > right
        if (left > right) {
            return result;
        }
        
        int cur;  // Current integer between 'left' and 'right'
        int temp;  // Temp reference to current integer
        int digit;  // Every digit of an integer
        // Checking process
        for(cur = left; cur <= right; cur++) {
            temp = cur;
            // Take out every digit of current integer
            while (temp % 10 != 0) {
                // Get the digit
                digit = temp % 10;
                // If cur % digit == 0, continue to the next digit
                if (cur % digit == 0) {
                    temp /= 10;
                }
                // Else continue to next Integer
                else {
                    break;
                }
            }
            // If temp <= 0, add 'cur' to list
            if (temp <= 0) {
                result.add(cur);
            }
        }
        
        return result;
    }
}
