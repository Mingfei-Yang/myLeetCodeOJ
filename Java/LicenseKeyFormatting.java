// 482. License Key Formatting

public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        
        // Invalid input K
        if (K < 1) {
            return S;
        }
        
        int len = S.length();
        StringBuilder sb = new StringBuilder();
        
        // O(len)
        for(int i = 0; i < len; i++) {
            if (S.charAt(i) != '-') {
                // Get all the alphanumerical characters and convert if needed
                sb.append( Character.toUpperCase( S.charAt(i) ) );
            }
        }
        
        len = sb.length();
        int firstPart = len % K;    // The length of first part of License Key
        int i = firstPart == 0 ? K : firstPart;
        
        // O(len)
        for( ; i < len; i += K + 1) {
            sb.insert(i, '-');
            len++;  // len++ because '-' has been inserted
        }
        
        return sb.toString();
    }
}
