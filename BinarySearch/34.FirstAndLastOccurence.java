class Solution {
    private int firstOccurence(int[] nums, int target){
        int first = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high){
           int mid = (high+low)/2;
            if(nums[mid] == target){
                first = mid;
                high = mid -1;

            }
            else if(nums[mid]<target){
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return first;
    }
    private int lastOccurence(int[] nums, int target){
        int last = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high){
         int mid = (low + high)/2;
            if(nums[mid] == target){
                last = mid;
                low = mid + 1;

            }
            else if(nums[mid]<target){
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        
        int first = firstOccurence(nums, target);
        if(first == -1) return new int[]{-1,-1};
         int last = lastOccurence(nums, target);

         return new int[]{first,last};
    }
}