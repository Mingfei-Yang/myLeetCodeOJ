// 38. Count and Say
// O(MN)

class Solution {
    public String countAndSay(int n) {
        /* Result String has to be generated from 1 to n */
        
        StringBuilder result = new StringBuilder("1");  // For n = 1
        int count;  // counter for current char
        char prev;  // previous char
        
        // Generate String from 1 to n
        for(int i = 2; i <= n; i++) {
            // Reset result for next integer
            StringBuilder temp = new StringBuilder();
            count = 1;  // char appears at least once
            prev = result.charAt(0);
            
            // Generate String for next Integer
            for(int j = 1; j < result.length(); j++) {
                // If char changed, append previous char
                if (result.charAt(j) != prev) {
                    temp.append(count);
                    temp.append(prev);
                    
                    count = 1;
                    prev = result.charAt(j);
                }
                else {
                    count++;
                }
            }
            // Append last character
            temp.append(count);
            temp.append(prev);
            
            // Assign new result
            result = temp;   
        }
        
        return result.toString();
    }
}
