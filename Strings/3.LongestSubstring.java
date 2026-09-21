class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mymap = new HashMap<>();
        int Maxcnt = 0;
       
         int cnt1 = 0;
        for(int i = 0;i<s.length();i++){ 
          if(mymap.containsKey(s.charAt(i))&& mymap.get(s.charAt(i))>=cnt1){
            cnt1 = mymap.get(s.charAt(i)) + 1;
          }

          mymap.put(s.charAt(i),i);
          Maxcnt = Math.max(Maxcnt, i - cnt1 + 1);
       

        
        }
        return Maxcnt;
    }
}