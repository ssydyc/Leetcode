public class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0, pre = 0, n = s.length();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == ' ') {
                if(res != 0) pre = res;
                res = 0;
            }
            else res ++;
        }
        return res == 0 ? pre : res;
    }
}
