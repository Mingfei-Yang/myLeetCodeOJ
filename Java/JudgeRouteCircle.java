// 657. Judge Route Circle

class Solution {
    public boolean judgeCircle(String moves) {
        
        int uNum = 0;  // Count U
        int dNum = 0;  // Count D
        int lNum = 0;  // Count L
        int rNum = 0;  // Count R
        
        for(int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    uNum++;
                    break;
                case 'D':
                    dNum++;
                    break;
                case 'L':
                    lNum++;
                    break;
                case 'R':
                    rNum++;
                default:
                    break;
            }
        }
        
        // If the moves match, then return true
        if (uNum == dNum && lNum == rNum) {
            return true;
        }
        
        return false;
    }
}
