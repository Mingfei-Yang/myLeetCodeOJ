// 771. Jewels and Stones

class Solution {
    public int numJewelsInStones(String J, String S) {
        
        int count = 0;  // Counter for Jewels in Stones
        
        if (J.length() == 0) {
            return 0;
        }
        
        // Scan thru the String S
        // Time Complexity - O(n), where n = S.length()
        for(int i = 0; i < S.length(); i++) {
            /** Using String.contains(CharSequence s)
              * Implementing Class of CharSequence:
              * CharBuffer, Segment, String, StringBuffer, StringBuilder
              */
            if ( J.contains( String.valueOf(S.charAt(i)) ) ) {
                count++;
            }
        }
        
        return count;
    }
}
