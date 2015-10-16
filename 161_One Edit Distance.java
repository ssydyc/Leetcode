public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length()>t.length()){
            String temp=s;
            s=t;
            t=temp;
        }
        boolean stop=false; //one chance to stop
        if(t.length()-s.length()>1) return false;
        int curt=0, curs=0;
        while(curt<t.length() && curs<s.length()){
            if(s.charAt(curs++)!=t.charAt(curt++)){
                if(!stop) {
                    if(s.length()!=t.length()) curs--;
                    stop=true;
                }
                else return false;
            }
        }
         return stop || (t.length()!=s.length() && curt==curs);
    }
}
