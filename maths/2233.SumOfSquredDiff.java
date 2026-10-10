import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        long[] d = new long[n + 1];
        for (int i = 0; i < n; i++) d[i] = Math.abs(nums1[i] - nums2[i]);
        Arrays.sort(d, 0, n);
        // reverse to descending
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            long t = d[i]; d[i] = d[j]; d[j] = t;
        }
        d[n] = 0;

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt++;
            long cur = d[i], nxt = d[i + 1];
            long cost = cnt * (cur - nxt);
            if (k >= cost) {
                k -= cost;
            } else {
                long q = k / cnt, r = k % cnt;
                long level = cur - q;
                long rest = 0;
                for (int j = i + 1; j < n; j++) rest += d[j] * d[j];
                return rest + r * (level - 1) * (level - 1) + (cnt - r) * level * level;
            }
        }
        return 0;
    }
}