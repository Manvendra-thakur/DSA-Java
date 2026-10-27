class Solution {
    public int maxDepth(String s) {
        // Your code goes here
        int dep = 0, maxdep = 0;
        for(char c : s.toCharArray()) {
            if(c == '('){
                dep++;
                maxdep = Math.max(maxdep, dep);
            } else if(c == ')'){
                dep--;
            }
        }
        return maxdep;
    }
}