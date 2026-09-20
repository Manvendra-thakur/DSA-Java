class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int[] temp = new int[n];
        for(int i = 0;i<n;i++){
            if(nums[i]!=0){
                temp[cnt]=nums[i];
                cnt++;
            }
        }
        for(int j = 0;j<cnt;j++){
            nums[j]= temp[j];
        }
        for(int i = cnt;i<n;i++){
            nums[i] = 0;
        }
    }
}