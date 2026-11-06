import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int q = queries.length;
        Integer[] order = new Integer[q];
        for (int i = 0; i < q; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] cnt = new int[n + 1];   // requests per server inside the window
        int active = 0;               // distinct servers inside the window
        int left = 0, right = 0;      // window is logs[left..right-1]
        int m = logs.length;
        int[] ans = new int[q];

        for (int qi : order) {
            int t = queries[qi];

            // add logs with time <= t
            while (right < m && logs[right][1] <= t) {
                int sid = logs[right][0];
                if (cnt[sid] == 0) active++;
                cnt[sid]++;
                right++;
            }

            // remove logs with time < t - x
            while (left < right && logs[left][1] < t - x) {
                int sid = logs[left][0];
                cnt[sid]--;
                if (cnt[sid] == 0) active--;
                left++;
            }

            ans[qi] = n - active;
        }

        return ans;
    }
}