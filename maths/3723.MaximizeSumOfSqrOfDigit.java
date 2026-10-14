class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (num <= 0 || sum <= 0 || sum > 9 * num) return "";

        StringBuilder sb = new StringBuilder();
        int rem = sum;
        for (int i = 0; i < num; i++) {
            int d = Math.min(9, rem);
            sb.append(d);
            rem -= d;
        }
        return sb.toString();
    }
}