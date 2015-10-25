public class Solution {
    public boolean isMatch(String s, String p) {
        int sn=s.length(), pn=p.length();
        int si=0, pi=0;
        int s_prev=-1, p_prev=-1;
        while(si<sn){
            if(pi<pn&& (p.charAt(pi)=='?'|| s.charAt(si)==p.charAt(pi))){
                pi++;
                si++;
            }
            else if(pi<pn && p.charAt(pi)=='*'){
                s_prev=si+1;
                p_prev=pi++;
            }
            else if(p_prev>=0){
                si=s_prev;
                pi=p_prev;
            }
            else{
                return false;
            }
        }
        for(int i=pi; i<pn;i++){
            if(p.charAt(i)!='*') return false;
        }
        return true;
    }
}
