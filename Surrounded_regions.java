import java.util.*;

class point{
	int x;
	int y;
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Surrounded_regions {
	
	Queue<point> to_search=new LinkedList<point>();
	
	public void solve(char[][] board) {
		if(board.length==0) return;
        for(int i=0;i<board.length;i++){
        	if(board[i][0]=='O') BFS(i,0,board);
        	if(board[i][board[0].length-1]=='O') BFS(i,board[0].length-1,board);
        }
        	
        for(int j=0;j<board[0].length;j++){
        	if(board[0][j]=='O') BFS(0,j,board);
        	if(board[board.length-1][j]=='O') BFS(board.length-1,j,board);
        		
        }//end of for
        
        for(int i=0;i<board.length;i++)
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j]=='P') board[i][j]='O';
        		else if(board[i][j]=='O') board[i][j]='X';
        		
        	}
    }//end of solve
	
	public void BFS(int i, int j, char[][] board){
		board[i][j]='P';
		to_search.add(new point(i,j));
		while(!to_search.isEmpty()){
			point temp=to_search.poll();
			i=temp.x;
			j=temp.y;
			if(i!=0&& board[i-1][j]=='O'){
				to_search.add(new point(i-1,j));
				board[i-1][j]='P';
			}
			if(i!=board.length-1&& board[i+1][j]=='O'){
				to_search.add(new point(i+1,j));
				board[i+1][j]='P';
			}
			if(j!=0 && board[i][j-1]=='O'){
				to_search.add(new point(i,j-1));
				board[i][j-1]='P';
			}
			if(j!=board[0].length-1&& board[i][j+1]=='O'){
				to_search.add(new point(i,j+1));
				board[i][j+1]='P';
			}
		}
		
	}// end of DFS
}
