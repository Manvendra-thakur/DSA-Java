class Solution {
    public List<Integer> findMissingElements(int[] nums) {

      Arrays.sort(nums); 

        
      List<Integer> list = new ArrayList<>();

      for (int i = 0; i < nums.length - 1; i++) {

         int current = nums[i];
             while (current + 1 != nums[i + 1]) {
                 current++;
                   list.add(current);
    }
  }  

     return list;
    }
}
