public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length()==0) return 0;
        HashMap<Character, Integer> count= new HashMap<Character, Integer>();
        int start=0, end=0; // record the start and end
        int result=0;
        while(end!=s.length()){
            while(count.size()<3&& end!=s.length()){
                if(count.containsKey(s.charAt(end))) count.put(s.charAt(end),count.get(s.charAt(end))+1);
                else count.put(s.charAt(end),1);
                end++;
            }
            if(count.size()==3) result=Math.max(result,end-start-1);
            else result=Math.max(result,end-start);
            while(count.size()>2){
                count.put(s.charAt(start),count.get(s.charAt(start))-1);
                if(count.get(s.charAt(start))==0) count.remove(s.charAt(start));
                start++;
            }
        }
        return result;
    }
}
