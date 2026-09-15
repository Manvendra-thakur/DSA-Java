class Solution {

    public int Partitaion(int[] nums,int low , int high){
        int randomIndex = low + new Random().nextInt(high-low+1);
        swap(nums,low,randomIndex);
        int pivot = nums[low];
        int i = low;
        int j = high;
        while(i<j){
            while(nums[i]<=pivot&&i<=high-1){
                i++;
            }
            while(nums[j]>pivot&& j>=low+1){
                j--;
            }
            if(i<j){
                swap(nums,i,j);
            }
        }
        swap(nums,low,j);
        return j;
    }

    public void QuicAlgo(int[] nums,int low, int high){
        if(low<high){
          int Pindex = Partitaion(nums,low,high);
            QuicAlgo(nums, low, Pindex-1);
            QuicAlgo(nums, Pindex+1, high);
        }
    }
    public int[] quickSort(int[] nums) {

        QuicAlgo(nums, 0, nums.length-1);
        return nums;

    }
    public void swap(int[] nums,int i , int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]= temp;
    }
}