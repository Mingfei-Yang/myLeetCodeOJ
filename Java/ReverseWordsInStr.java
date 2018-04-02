// 151. Reverse Words in a String
public class Solution {
    public String reverseWords(String s) {
        // String Builder for Result
        StringBuilder result = new StringBuilder();
        
        // Temp StringBuilder for a single word
        StringBuilder temp = new StringBuilder();
        
        // Traverse the input String from the tail to the head
        // Append each word to result from the tail
        for (int i = s.length() - 1; i >= 0; i--) {
            // if a SPACE is met:
            if (s.charAt(i) == ' ') {
                // If temp.length() == 0, continue
                if (temp.length() == 0) {
                    continue;
                }
                // Else add the word to the result
                else {
                    // Add a single SPACE if the length of result is greater than 0
                    if (result.length() > 0) {
                        result.append(' ');
                    }
                    // Append the word
                    // The word in temp is in inverse order
                    result.append(temp.reverse().toString());
                    // Reset the temp StringBuilder
                    temp = new StringBuilder();
                }
            }  // End of "if a SPACE is met"
            // Else: Add it to temp
            else {
                temp.append(s.charAt(i));
            }      
        }  // End of for-loop
        
        // Append the last word if needed
      	if (temp.length() != 0) {
          	// Add a single SPACE if the length of result is greater than 0
            if (result.length() > 0) {
                result.append(' ');
            }
          	result.append(temp.reverse().toString());
      	}
        
        return result.toString();
    }
}
