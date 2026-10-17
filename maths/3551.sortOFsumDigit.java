import java.util.*;

class Solution {
    private int digitSum(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> {
            int da = digitSum(nums[a]), db = digitSum(nums[b]);
            if (da != db) return Integer.compare(da, db);
            return Integer.compare(nums[a], nums[b]);
        });

        boolean[] visited = new boolean[n];
        int cycles = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cycles++;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = idx[j];
                }
            }
        }
        return n - cycles;
    }
}