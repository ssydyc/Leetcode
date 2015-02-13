public class Solution {
    private boolean compare(Character a, Character b){
        if(a==b || a=='.'||b=='.') return true;
        return false;
    }
    
    private boolean myMatch(String s, String p, int sStart, int pStart){
        if(sStart==s.length()&&pStart==p.length()) return true;
        if(pStart==p.length()) return false; // extreme cases
        boolean result=false;
        if(p.charAt(pStart)!='*'){
            if(pStart+1==p.length()||p.charAt(pStart+1)!='*'){
                if(sStart==s.length()) return false;
                if(compare(p.charAt(pStart),s.charAt(sStart))) return myMatch(s,p,sStart+1,pStart+1);
            }
            else{
                if(sStart==s.length()) return myMatch(s,p,sStart,pStart+2);
                if(compare(p.charAt(pStart),s.charAt(sStart))) return myMatch(s,p,sStart+1,pStart+1)||myMatch(s,p,sStart,pStart+2);
                else return myMatch(s,p,sStart,pStart+2);
            }
        }
        
        else {
            // having '*', greedy, reach as far as we can
            int match=0;
            while(sStart<s.length()&&compare(p.charAt(pStart-1),s.charAt(sStart))) {
                match++; // how many did '*' matches at most
                sStart++;
            }
           
            while(match>0){
                result=result||myMatch(s,p,sStart,pStart+1);
                if(result) return result; // we get a True
                match--;
                sStart--;
            }
            return myMatch(s,p,sStart,pStart+1);
        }
        return false;
    }
    
    public boolean isMatch(String s, String p) {
        return myMatch(s,p,0,0);
    }
}
