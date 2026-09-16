class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        String s = "";

        for(int i = 0;i<n-2;i++){
            if(num.charAt(i)==num.charAt(i+1)&&num.charAt(i)==num.charAt(i+2)){
                String Cur = num.substring(i,i+3);
                if(Cur.compareTo(s)>0){
                    s = Cur;
                }

            }
            
        }
        if(s==null) return "";
        return s;
    }
}