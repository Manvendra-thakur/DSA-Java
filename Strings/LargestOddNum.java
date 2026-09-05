class Solution {
    public String largestOddNumber(String num) {
        
        int j=-1;
        int n = num.length();
        int i;
        for( i=n-1;i>=0;i--){
            if((num.charAt(i)-'0')%2==1){
            j=i;
            break;
            }
        }
        if(j==-1) return "";
        i=0;
        while(i<j&&num.charAt(i)=='0')
            i++;
    
        return num.substring(i,j+1);
    }
}