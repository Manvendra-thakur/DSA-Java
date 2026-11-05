import java.util.*;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int x : arr1) {
            // lower bound: first index with arr2[idx] >= x - d
            int lo = 0, hi = arr2.length;
            long target = (long) x - d;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (arr2[mid] >= target) hi = mid;
                else lo = mid + 1;
            }
            // good if no such element, or it lies beyond x + d
            if (lo == arr2.length || (long) arr2[lo] > (long) x + d) {
                count++;
            }
        }
        return count;
    }
}