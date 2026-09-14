class Solution {
    public void sort(int[] nums,int low,int mid , int high){
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left<=mid&&right<=high){

            if(nums[left]<=nums[right]){
                temp.add(nums[left]);
                left++;
            } else{
                temp.add(nums[right]);
                right++;
            }
        }
        while(left<=mid){
             temp.add(nums[left]);
                left++;
        }
        while(right<=high){
             temp.add(nums[right]);
                right++;
        }
        for(int i = low;i<=high;i++){
            nums[i] = temp.get(i-low);
        }



    }

    public void Ms(int[] nums,int low, int high){
        if(low>=high)
        return;
        int mid = (low + high)/2;
        Ms(nums, low, mid);
        Ms(nums,mid+1,high);

        sort(nums,low,mid,high);
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        
        Ms(nums, 0, n-1);
        
        return nums;

        
        
    }
}