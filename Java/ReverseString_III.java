// 557. Reverse String III
// StringBuilder

class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        // Split the original string by SPACE
        String[] strArr = s.split(" ");       
        // For each substring in Array, reverse it
        for (int i = 0; i < strArr.length; i++) {
            StringBuilder builder = new StringBuilder(strArr[i]);
            result.append(builder.reverse().toString());
            
            if (i < strArr.length - 1) {
                result.append(' ');
            }
        }
        
        return result.toString();
    }
}
