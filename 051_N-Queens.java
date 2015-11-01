class position{
    int x,y;
    public position(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Solution {
    // add Queue by row
    
    private boolean isValid(int row, int col, List<position> pos){
        for(position temp: pos){
            if(temp.y==col || Math.abs(temp.x-row)==Math.abs(temp.y-col)) return false;
        }
        return true;
    }
    
    private void addResult(List<List<String>> res, List<position> pos, int n){
        char[] temp= new char[n];
        Arrays.fill(temp,'.');
        List<String> temp2= new ArrayList<String>();
        for(position temp1: pos){
            temp[temp1.y]='Q';
            temp2.add(new String(temp));
            temp[temp1.y]='.';
        }
        res.add(temp2);
    }
    
    private void helper(int cur, int n, List<List<String>> res, List<position> pos){
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
                pos.remove(pos.size()-1);
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<position> pos= new ArrayList<position>();
        List<List<String>> res= new ArrayList<List<String>>();
        helper(0, n, res, pos);
        return res;
    }
}
