// 696. Count Binary Substrings
// Linear solution
class Solution {
    public int countBinarySubstrings(String s) {
        
        if (s.length() < 2) {
            return 0;
        }
        
        int count = 0;  // Count for valid substrings
        int prev = 0, curr = 1;
        
        // Linear Scan
        for(int i = 1; i < s.length(); i++) {
            // If prev char and curr char are not the same
            if (s.charAt(i) != s.charAt(i - 1)) {
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
            else {
                curr++;
            }
        }
        
        return count + Math.min(prev, curr);
    }
}
