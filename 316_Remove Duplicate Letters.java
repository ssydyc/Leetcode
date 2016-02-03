public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int n = s.length();
        int unique = 0;
        String res = "";
        for(int i = 0; i < n; i++)
            if(count[s.charAt(i) - 'a']++ == 0) unique++;
        for(int i = 0; i < unique; i++) {
            // count number
            Arrays.fill(count, 0);
            char start = s.charAt(0);
            int ind = 0;
            for(int j = 0; j < s.length(); j++) count[s.charAt(j) - 'a']++ ;
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) < start) {
                    ind = j;
                    start = s.charAt(j);
                }
                if(--count[s.charAt(j) - 'a'] == 0) break;
            }
            res += start;
            s = s.substring(ind + 1).replace(String.valueOf(start), "");
        }
        return res;
    }
}
