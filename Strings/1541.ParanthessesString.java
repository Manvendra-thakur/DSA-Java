class Solution {
    public int minInsertions(String s) {
        int open = 0, ans = 0, i = 0, n = s.length();

        while (i < n) {
            if (s.charAt(i) == '(') {
                open++;
                i++;
            } else {
                // ')' mila
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i += 2;      // "))" ka pair mil gaya
                } else {
                    ans++;       // ek ')' insert karna pada
                    i++;
                }

                if (open > 0) {
                    open--;      // kisi '(' se match ho gaya
                } else {
                    ans++;       // match karne ke liye '(' insert karna pada
                }
            }
        }
        return ans + open * 2;
    }
}