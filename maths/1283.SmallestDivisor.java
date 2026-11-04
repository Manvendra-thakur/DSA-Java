class Solution {

    private int SumByD(int[] nums, int threshold){
        int sum = 0;
        for(int x : nums){
            sum += Math.ceil((double)x/(double)threshold);
        }
        return sum;
    }
      public int smallestDivisor(int[] nums, int threshold) {
           int n = nums.length;
           if(n > threshold) return -1;

           int maxi = Integer.MAX_VALUE;
         for(int i : nums){
             maxi = Math.max(maxi, i);
             }

          int low = 0,high = maxi;
        while(low <= high){
             int mid = low + (high-low)/2;
             if(SumByD(nums, mid) <= threshold){
                high = mid - 1;
             } else {
                low = mid + 1;
            }
        }
        return low;
  }
}