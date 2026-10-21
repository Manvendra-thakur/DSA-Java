import java.util.Arrays;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);

        if (s.equals(sorted)) return 0;

        int L = 0;
        while (s.charAt(L) == sorted.charAt(L)) L++;
        int R = n - 1;
        while (s.charAt(R) == sorted.charAt(R)) R--;

        if (L > 0 || R < n - 1) return 1;

        char minC = sorted.charAt(0);
        char maxC = sorted.charAt(n - 1);
        int firstMin = s.indexOf(minC);
        int lastMax = s.lastIndexOf(maxC);

        if (firstMin <= n - 2 || lastMax >= 1) return 2;

        return n == 2 ? -1 : 3;
    }
}