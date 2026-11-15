package DP;

public class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int even = 1;      // empty prefix (sum 0) counts as even
        int odd = 0;
        int parity = 0;    // parity of current prefix sum
        long ans = 0;

        for (int x : arr) {
            parity = (parity + x) & 1;

            if (parity == 1) {     
                ans += even;
                odd++;
            } else {                
                ans += odd;
                even++;
            }
            ans %= MOD;
        }
        return (int) ans;
    }
} {
    
}
