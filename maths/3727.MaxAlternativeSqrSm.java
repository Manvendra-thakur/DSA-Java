import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] sq = new long[n];
        for (int i = 0; i < n; i++) {
            sq[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(sq);

        int minusCount = n / 2;         
        long score = 0;
        for (int i = 0; i < minusCount; i++) {
            score -= sq[i];
        }
        for (int i = minusCount; i < n; i++) {
            score += sq[i];
        }
        return score;
    }
}