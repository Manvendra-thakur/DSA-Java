class Solution {
    public int sortPermutation(int[] nums) {
         int result = -1; 
        boolean unsorted = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                result &= i;
                unsorted = true;
            }
        }

        return unsorted ? result : 0;
    }
}