class Solution {
    public List<Integer> generateRow(int rows){
        long prev = 1;
        List<Integer> rowAns = new ArrayList<>();

        rowAns.add(1);
        for(int col = 1;col<rows;col++){
            prev = prev * (rows - col);
            prev = prev / col;
            rowAns.add((int)prev);
        }
        return rowAns;

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int rows = 1;rows<=numRows;rows++){
            ans.add(generateRow(rows));

        }
        return ans;
    }
}