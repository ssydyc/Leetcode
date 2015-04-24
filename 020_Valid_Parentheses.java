/** decide whether it's a valid parenthese
 * @author SamSong
 */

public class Solution {
    private boolean postParentheses(char s){
        if(s==')'||s=='}'||s==']') return true;
        return false;
    }
    
    private boolean Match(char a, char b){
        if(a=='('&&b==')') return true;
        if(a=='['&&b==']') return true;
        if(a=='{'&&b=='}') return true;
        return false;
    }
    
    public boolean isValid(String s) {
        Stack<Character> newStack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(postParentheses(s.charAt(i))){
                if(newStack.empty()) return false;
                if(!Match(newStack.pop().charValue(),s.charAt(i))) return false;
            }
            else newStack.push(new Character(s.charAt(i)));
        }
        if(newStack.empty())return true;
        return false;
    }
}
