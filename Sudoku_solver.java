import java.util.*;

public class Sudoku_solver {
	
	 public void solveSudoku(char[][] board) {
		 my_solver(board);
	 }
	 
	public boolean my_solver(char[][] board){
		int[] next=find_next(board);
		if(next[0]==-1) return true; // we have finished Sudoku
		HashSet<Character> hset=new HashSet<Character>();
		for(int i=0;i<9;i++){
			hset.add(board[next[0]][i]);
			hset.add(board[i][next[1]]);
		}
		for(int m=0;m<3;m++)
			for(int n=0;n<3;n++)
				hset.add(board[next[0]/3*3+m][next[1]/3*3+n]);
		for(char c='1';c<='9';c++){
			if(!hset.contains(c)){
				board[next[0]][next[1]]=c;
				if(my_solver(board)) return true;
			}//end of if
		}
		board[next[0]][next[1]]='.';
		return false;
	}
	
	public int[] find_next(char[][] board){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(board[i][j]=='.') {int[] temp={i,j}; return temp;}
			}
		}
		int[] temp={-1,-1};
		return temp;
	}
	
}
