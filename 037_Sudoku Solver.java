public class Solution {
    public void solveSudoku(char[][] board) {
        int[] res=getNext(0,-1,board);
        helper(res[0],res[1], board);
        return;
    }
    
    private boolean helper(int x, int y, char[][] board){
        if(x==9) return true;
        boolean[] flag=new boolean[9];
        Arrays.fill(flag,false);
        for(int i=0;i<9;i++){
            if(board[i][y]!='.')
                flag[(int)board[i][y]-(int)'1']=true;
            if(board[x][i]!='.')
                flag[(int)board[x][i]-(int)'1']=true;
        }
        int tempx=x/3*3;
        int tempy=y/3*3;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                if(board[tempx+i][tempy+j]!='.')
                    flag[(int)board[tempx+i][tempy+j]-(int)'1']=true;
            }
        int[] res=getNext(x,y,board);
        for(int i=0;i<9;i++){
            if(!flag[i]){
                board[x][y]=(char)((int)'1'+i);
                if(helper(res[0],res[1],board)) return true;
                board[x][y]='.';
            }
        }
        return false;
    }
    
    private int[] getNext(int x, int y, char[][] board){
        do {
            if(++y==9){
                x++;
                y=0;
            }
        } while(x!=9 && board[x][y]!='.');
        int[] res={x,y};
        return res;
    }
}
