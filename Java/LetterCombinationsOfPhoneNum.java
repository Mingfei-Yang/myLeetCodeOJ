// 17. Letter Combinations of a Phone Number
// Recursive solution

public class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<String>();
        
        if (digits.length() == 0) {
            return result;
        }
        
        // Call backtracking method to generate result list
        /* Args: current string, input digits, num of visited digit, result list */
        backTracking(new StringBuilder(), digits, 0, result);
        
        return result;
    }
    
    private void backTracking(StringBuilder curStr, String digits, int offset, List<String> result) {
        if (offset > digits.length() - 1) {
            result.add(curStr.toString());
            return;
        }
        
        String str = getButtonStr( digits.charAt(offset) );
        
        for(int i = 0; i < str.length(); i++) {
            // Append the char
            backTracking(curStr.append( str.charAt(i) ), digits, offset + 1, result);
            
             // Remove the most recently added char
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }
    
    // Get String according to Button
    private String getButtonStr(char digit) {
        switch (digit) {
            case '0':
                return " ";
            case '1':
                return "1";
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}
