class Solution {
    public String boldWords(String[] words, String s) {
        int n = s.length();
        int[] diff = new int[n + 1];

        for (String w : words) {
            int len = w.length();
            if (len == 0) continue;
            for (int i = s.indexOf(w); i != -1; i = s.indexOf(w, i + 1)) {
                diff[i]++;
                diff[i + len]--;
            }
        }

        StringBuilder sb = new StringBuilder();
        int cover = 0;
        boolean open = false;
        for (int i = 0; i < n; i++) {
            cover += diff[i];
            if (cover > 0 && !open) {
                sb.append("<b>");
                open = true;
            } else if (cover == 0 && open) {
                sb.append("</b>");
                open = false;
            }
            sb.append(s.charAt(i));
        }
        if (open) sb.append("</b>");

        return sb.toString();
    }
}