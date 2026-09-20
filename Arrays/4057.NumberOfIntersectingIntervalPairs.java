class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0;i<n;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
            
        }

        Arrays.sort(start);
        Arrays.sort(end);
        long nonintersect = 0;
        int endptr = 0;
        for(int start1:start){

            while(endptr<n&&end[endptr]<start1){
                endptr++;
            }
            nonintersect += endptr;
        }
        long total = ((long)n*(n-1))/2;
        return total - nonintersect;
    }
}