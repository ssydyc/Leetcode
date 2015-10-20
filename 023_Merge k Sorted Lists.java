public class Solution {
    
    private void helper(List<String> res, int open, int close, int n, StringBuilder temp){
        if(open==n&& close==n) res.add(temp.toString());
        if(open<n){
            temp.append('(');
            helper(res,open+1,close,n, temp);
            temp.deleteCharAt(temp.length()-1);
        }
        if(close<open){
            temp.append(')');
            helper(res,open,close+1,n, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<String>();
        helper(res, 0, 0, n, new StringBuilder(2*n));
        return res;
    }
}
