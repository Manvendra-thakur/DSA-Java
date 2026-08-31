class Solution {
    public boolean isPalindrome(int x) {
        int copy = x;
        
        int res = 0;
        while(x>0){
            int rem = x%10;
            res = res*10+rem;
            x = x/10;

        }

        return copy == res;
        
    }
}