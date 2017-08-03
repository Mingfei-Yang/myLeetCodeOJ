// 396. Rotate Function
/* **********
 F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[len - 1] - (len - 1) * Bk[0]
               = Bk[0] + Bk[1] + ... + Bk[len - 1] - len * Bk[0]
               = ArrSum - len * Bk[0]
********** */

public class Solution {
    public int maxRotateFunction(int[] A) {
        
        int len = A.length;
        
        if (len <= 1) {
            return 0;
        }
        
        int f = 0;  // F(k-1)
        int sum = 0;
        
        /* F(k) = F(k-1) + sum - len * Bk[0] */
        // Calculate the sum, and F(0)
        for(int i = 0; i < len; i++) {       
            f += i * A[i];
            sum += A[i];
        }
        
        int max = f;  // Current max value
        
        // Calculate the F(k) using F(k-1), sum and each Bk[0]
        // Starting from F(1) = F(0) + sum - len * B1[0]
        // Bk[0] = A[len - k]
        for(int i = len - 1; i > 0; i--) {
            f = f + sum - len * A[i];
            
            if (f > max) {
                max = f;
            }
        }
        
        return max;
    }
}
