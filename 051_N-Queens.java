class position{
    int x,y;
    public position(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Solution {
    // add Queue by row
    
    private boolean isValid(int row, int col, HashSet<position> pos){
        for(position temp: pos){
            if(temp.y==col || Math.abs(temp.x-row)==Math.abs(temp.y-col)) return false;
        }
        return true;
    }
    
    private void addResult(List<List<String>> res, HashSet<position> pos, int n){
        char[][] temp= new char[n][n];
        for(position temp1: pos){
            Arrays.fill(temp[temp1.x],'.');
            temp[temp1.x][temp1.y]='Q';
        }
        List<String> temp2= new ArrayList<String>();
        for(char[] temp1: temp)
            temp2.add(new String(temp1));
        res.add(temp2);
    }
    
    private void helper(int cur, int n, List<List<String>> res, HashSet<position> pos){
        if(cur==n) {
            addResult(res, pos,n);
           return;
        }
        for(int col=0; col<n; col++){
            // add the position (cur, col)
            if(isValid(cur, col, pos)){
                position temp=new position(cur,col);
                pos.add(temp);
                helper(cur+1,n,res,pos);
                pos.remove(temp);
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        HashSet<position> pos= new HashSet<position>();
        List<List<String>> res= new ArrayList<List<String>>();
        helper(0, n, res, pos);
        return res;
    }
}
