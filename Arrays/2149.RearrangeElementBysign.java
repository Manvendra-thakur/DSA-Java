class Solution {
    public int[] rearrangeArray(int[] nums) {
        int negindex = 1;
        int posindex = 0;
        int[] ans = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<0){
                ans[negindex] = nums[i];
                negindex += 2;
            }
            else {
                ans[posindex] = nums[i];
                posindex += 2;
            }
        }
        return ans;
    }
}
