// 806. Number of Lines to Write String
class Solution {
    
    private int lineUnit = 100;
    
    public int[] numberOfLines(int[] widths, String S) {
        
        if (widths.length == 0 || S.length() == 0) {
            return new int[] {0, 0};
        }
        
        // Return integer array
        int[] array = new int[2];
        int units = 0;  // count total units used in ONE line
        int lines = 0;  // count line number needed
        int current = 0;  // the units needed for ONE character
        
        // Traverse the String and get units we need
        for(int i = 0; i < S.length(); i++) {
            // Get the units needed for current character
            current = widths[Integer.valueOf(S.charAt(i) - 'a')];
            
            // If current line does not have enough space
            if (lineUnit - units < current) {
                lines += 1;  // Line number + 1
                units = 0;  // Reset units
            }
            
            // Update space used in current line
            units += current;
        }
        
        array[0] = units == 0 ? lines : lines + 1;
        array[1] = units;
        
        return array;
    }
}
