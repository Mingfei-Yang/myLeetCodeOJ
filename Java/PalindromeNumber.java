// 9. Palindrome Number

class Solution {
    public boolean isPalindrome(int x) {
        // If x is negative or (x > 0 and x % 10 == 0), return false
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        
        // Reverse number
        int reverse = 0;
        
        // While current x > reverse
        // "Split" the # of digits in input integer, x
        // The # of digits, say N, in x is even, x and reverse will both contain N/2 digits after iteration
        // If N is odd, reverse will contain 1 more digit than x after iteration
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        
        // If reverse == x, then it's a palindrome (N is even)
        // If reverse/10 == x, then it's a palindrome (N is odd)
        // reverse/10 eliminates the last digit in variable reverse
        return (x == reverse || x == reverse / 10);
    }
}
