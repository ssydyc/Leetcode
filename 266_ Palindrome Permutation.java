public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character,Boolean> count= new HashMap<Character,Boolean>();
        for(int i=0;i<s.length();i++){
            if(!count.containsKey(s.charAt(i))) count.put(s.charAt(i),true);
            else count.put(s.charAt(i),!count.get(s.charAt(i)));
        }
        int result=0;
        for(Boolean temp: count.values()){
            if(temp) result++;
        }
        if(result>1) return false;
        else return true;
    }
}
