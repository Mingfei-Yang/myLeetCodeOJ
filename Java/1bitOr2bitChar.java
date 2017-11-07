// 717. 1-bit or 2-bit characters
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        
        if (bits.length == 0) {
            return false;
        }
        
        // If last bit is not 0, return false
        if (bits[bits.length - 1] != 0) {
            return false;
        }
        
        // The pointer that represents the postion in the array
        int pointer;
        // Traverse and compare bits in the array, but leave the last bit
        for(pointer = 0; pointer < bits.length - 1; pointer++) {
            // 10 and 11 are both valid, move to the Third bits from bits i
            if (bits[pointer] == 1 && pointer + 1 < bits.length) {
                pointer = pointer + 1;
            }
            // 0 is the only one-bit character
            else if (bits[pointer] == 0) {
                continue;
            }
            else {
                return false;
            }
        }
        
        // If pointer points to the last bit, i.e. index == (bits.length - 1) 
        // Then it must be a single 0, return true
        if (pointer == bits.length - 1) {
            return true;
        }
        
        return false;
    }
}
