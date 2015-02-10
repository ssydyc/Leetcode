import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int start=-1;
        int end=0;
        int maxLength=0;
        HashSet hs = new HashSet();
        while(end<s.length()){
            if(!hs.contains(s.charAt(end))){
                // add another one
                hs.add(s.charAt(end));
                end++;
            }
            else{
                // s[end] is in hashset
                maxLength=Math.max(maxLength,end-start-1);
                while(s.charAt(++start)!=s.charAt(end)){
                    hs.remove(s.charAt(start));
                }
                end++;
            }
        }
        maxLength=Math.max(maxLength,end-start-1);
        return maxLength;
    }
}
