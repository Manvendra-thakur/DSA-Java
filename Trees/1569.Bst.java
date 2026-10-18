import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final long MOD = 1_000_000_007L;
    private long[][] C;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        C = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }

        
        return (int) ((count(list) - 1 + MOD) % MOD);
    }

    private long count(List<Integer> arr) {
        if (arr.isEmpty()) {
            return 1;
        }
        int root = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            int x = arr.get(i);
            if (x < root) {
                left.add(x);
            } else {
                right.add(x);
            }
        }
        long ways = C[arr.size() - 1][left.size()];
        return ways * count(left) % MOD * count(right) % MOD;
    }
}