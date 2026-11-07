import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]); // {weight, index}
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        }); // {freeTime, weight, index}

        for (int i = 0; i < servers.length; i++) free.offer(new int[]{servers[i], i});

        int m = tasks.length;
        int[] ans = new int[m];
        long t = 0;

        for (int j = 0; j < m; j++) {
            t = Math.max(t, j);
            if (free.isEmpty()) t = busy.peek()[0];

            while (!busy.isEmpty() && busy.peek()[0] <= t) {
                long[] s = busy.poll();
                free.offer(new int[]{(int) s[1], (int) s[2]});
            }

            int[] s = free.poll();
            ans[j] = s[1];
            busy.offer(new long[]{t + tasks[j], s[0], s[1]});
        }
        return ans;
    }
}