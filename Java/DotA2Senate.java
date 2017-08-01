// 649. DotA2 Senate
// Greedy

public class Solution {
    public String predictPartyVictory(String senate) {
        
        char[] senateArr = senate.toCharArray();
        int r = 0;  // Total amount of R
        int d = 0;  // Total amount of D
        
        // Count the total number of Radiant and Dire
        for(char c : senateArr) {
            if (c == 'R') {
                r++;
            }
            else {
                d++;
            }
        }
        
        int start = 0;
        int len = senateArr.length;
        while (r > 0 && d > 0) {
            // Get to the first senate with right
            while (senateArr[start] != 'R' && senateArr[start] != 'D') {
                start = (start + 1) % len;
            }
            
            char ban;  // Senate that will be Banned
            if (senateArr[start] == 'R') {
                d--;  // Dire will be banned
                ban = 'D';
            }
            else {
                r--;  // Radiant will be banned
                ban = 'R';
            }
            
            // Get to the senate that will be banned (the closest opponent senate)
            int i = (start + 1) % len;
            while (senateArr[i] != ban) {
                i = (i + 1) % len;
            }
            senateArr[i] = ' ';  // Replace banned senate with SPACE
            
            start = (start + 1) % len;
        }
        
        return r > 0 ? "Radiant" : "Dire";
    }
}
