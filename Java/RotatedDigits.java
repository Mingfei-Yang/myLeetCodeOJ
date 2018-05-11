// 788. Rotated Digits

class Solution {
    public int rotatedDigits(int N) {
        // A number is Good if:
        // - it does not contain 3, 4, 7
        // - it does not only consist of 0, 1, 8 or combination of them.
        int count = 0;
        
        for (int i = 0; i <= N; i++) {
            String numberStr = Integer.toString(i);
            
            if (numberStr.contains("3") || numberStr.contains("4") || numberStr.contains("7")) {
                continue;
            }
            else if (numberStr.contains("1") || numberStr.contains("0") || numberStr.contains("8")) {
                if (numberStr.contains("2") || numberStr.contains("5") || numberStr.contains("6") || numberStr.contains("9")) {
                    count++;
                }
                else {
                    continue;
                }
            }
            else {
                count++;
            }
        }
        
        return count;
    }
}
