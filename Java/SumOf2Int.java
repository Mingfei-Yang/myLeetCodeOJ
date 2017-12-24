// 371. Sum of Two Integers
// Bit Manipulation
class Solution {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        // When a and b are non-zero
        while (b != 0) {
            // Carry bit
            int carry = a & b;
            a = a ^ b;  // or
            b = carry << 1;  // shift left
        }
        
        return a;
    }
}
