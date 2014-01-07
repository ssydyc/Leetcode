import java.util.HashSet;

public class Valid_sudoku {
	public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hset=new HashSet<Character>();
        for(int i=0;i<9;i++){
        	hset.clear();
        	set_hash(hset);
        	for(int j=0;j<9;j++){
        		if(board[i][j]!='.'&&!hset.remove(board[i][j])) return false; 
        	}
        }//end of for
        for(int i=0;i<9;i++){
        	hset.clear();
        	set_hash(hset);
        	for(int j=0;j<9;j++){
        		if(board[j][i]!='.'&&!hset.remove(board[j][i])) return false; 
        	}
        }//end of for
        for(int i=0;i<9;i+=3)
        	for(int j=0;j<9;j+=3){//starting index: 3i,3j
        		hset.clear();
            	set_hash(hset);
            	for(int m=0;m<3;m++)
            		for(int n=0;n<3;n++){
            			if(board[i+m][j+n]!='.'&&!hset.remove(board[i+m][j+n])) return false; 
            		}
        		
        	}
        return true;
    }
	
	public void set_hash(HashSet<Character> hset){
		for(char c='1';c<='9';c++){
			hset.add(c);
		}
	}
}
