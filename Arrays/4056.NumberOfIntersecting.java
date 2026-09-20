class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n<1){
            return 0;
        }
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0;i<n;i++){
            start[i] = intervals[i][0];
            end[i]= intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int nonintersecting = 0;
        int ptr = 0;
        for(int start1:start){

            while(ptr<n&&end[ptr]<start1){
                ptr++;
            }
            nonintersecting += ptr;
            
            
        }
        int total = (n*(n-1))/2;
            return total - nonintersecting;
        
    }
}