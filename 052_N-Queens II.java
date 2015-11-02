public class Solution {
    // add Queue by row
    private int res=0;
    
    private boolean isValid(int row, int col, int[] pos){
        int n=pos.length;
        for(int i=0;i<n && pos[i]!=-1; i++){
            if(pos[i]==col || Math.abs(i-row)==Math.abs(pos[i]-col)) return false;
        }
        return true;
    }

    private void helper(int cur, int n, int[] pos){
        if(cur==n) {
           res++;
           return;
        }
        for(int col=0; col<n; col++){
            // add the position (cur, col)
            if(isValid(cur, col, pos)){
                pos[cur]=col;
                helper(cur+1,n,pos);
                pos[cur]=-1;
            }
        }
    }
    
     public int totalNQueens(int n) {
        int[] pos= new int[n];
        Arrays.fill(pos,-1);
        res=0;
        helper(0, n, pos);
        return res;
    }
}
