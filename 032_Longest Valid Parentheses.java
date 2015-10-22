public class Solution {
    
   private int alwaysMoreOpen(int start, int end, String s){
    // return the length of longest valid parentheses when the num of left paranthesis is always more 
    int diff=0, temp=0, res=0;
    for(int i=end; i>start;i--){
        if(s.charAt(i)==')') diff++;
        else {
            if(diff>0){
                diff--;
                temp+=2;
            }
            else{
                res=Math.max(temp,res);
                temp=0;
            }
        }
    }
    return Math.max(temp,res);
}

public int longestValidParentheses(String s) {
    int start=-1,end=0, diff=0, res=0;
    while(end<s.length()){
        if(s.charAt(end)=='(') diff++;
        else{
            if(diff==0) {
                // the boundary that the number of right parenthesis is more
                res=Math.max(res,alwaysMoreOpen(start,end-1,s));
                start=end;
            }
            else diff--;
        }
        end++;
    }
    return Math.max(res,alwaysMoreOpen(start,end-1,s));
}
}
