public class Solution {

    private boolean existMoveWin(StringBuilder s, boolean flag){
        boolean result=flag;
        for(int i=1; i<s.length();i++){
            if(s.charAt(i)=='+'&& s.charAt(i-1)=='+'){
                s.setCharAt(i-1,'-');
                s.setCharAt(i,'-');
                result=existMoveWin(s,!flag);
                s.setCharAt(i-1,'+');
                s.setCharAt(i,'+');
                if(result!=flag) break;
            }
        }
        return result;
    }
    
    public boolean canWin(String s) {
        return existMoveWin(new StringBuilder(s),false);
    }
}
