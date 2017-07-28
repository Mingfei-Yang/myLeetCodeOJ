// 11. Container with Most Water
// Two-pointer method

public class Solution {
    public int maxArea(int[] height) {
        
        int len = height.length;
        
        if (len == 2) {
            return Math.min(height[0], height[1]);        
        }
        
        int max = 0;  // Max area
        int h;  // Min height of two vertical lines
        int area;  // Current area
        int start = 0;  // Pointer which moves from the start
        int end = len - 1;  // Pointer which moves from the end
        
        while (start < end) {
            // Get the min height and calculate the area
            h = Math.min(height[start], height[end]);
            area = h * (end - start);
            // Update max if it's needed
            if (area > max) {
                max = area;
            }
            // Update start and end accordingly
            if (height[start] < height[end]) {
                start++;
            }
            else {
                end--;
            }
        }
        
        return max;
    }
}
