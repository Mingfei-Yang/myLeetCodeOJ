// 476. Number Complement

public class Solution {
    public int findComplement(int num) {
        
        String bStr = Integer.toBinaryString(num);
        char[] bCharArray = bStr.toCharArray(); // Char array of binary string
        int i, j, complement = 0;
        
        // 0s would become 1s in complement
        for(i = bCharArray.length - 1, j = 0; i >= 0; i--, j++) {
            if (bCharArray[i] == '0')
                complement += (int) Math.pow(2, j);
        }
        
        return complement;
    }
}
