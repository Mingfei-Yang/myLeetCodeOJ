// 283. Move Zeroes
// Two Pointers, in-place
class Solution {
    public void moveZeroes(int[] nums) {
        
        // If the length of nums is less than 2, no need to move
        if (nums.length < 2) {
            return;
        }
        
        int p1;  // Pointer moving from the beginning to the end
        int p2;  // Pointer for the swapping element
        int i = 0, j = 1;  // Index for p1 and p2
        
        while (i < nums.length && j < nums.length) {
            p1 = nums[i];
            p2 = nums[j];
            
            // If p1 == p2 == 0, move p2 to the next element
            if (p1 == p2 && p1 == 0) {
                j++;
            }
            // Else if p1 == 0 && p2 != 0, swap p1 and p2, move pointers to their next
            else if (p1 == 0 && p2 != 0) {
                nums[i] = p2;
                nums[j] = p1;
                i++;
                j++;
            }
            // Else only move pointers (p1 != 0 && p2 != 0) || (p1 != 0 && p2 == 0)
            else {
                i++;
                j++;
            }
        }
    }
}
