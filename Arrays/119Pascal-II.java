public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] ans = new int[rowIndex+1];
        ans[0] = 1;
        for(int i = 1;i<rowIndex;i++){
            ans[i] = (ans[i] * (rowIndex-i))/(i);
        }
        List<Integer> list = new ArrayList<>();
        for(int nums:ans){
            list.add(nums);

        }
        return list;
    }
} 
