public class Solution {
	public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hset=new HashSet<Character>();
        for(int i=0;i<9;i++){
        	hset.clear();
        	for(int j=0;j<9;j++){
        		if(board[i][j]!='.'&&!hset.add(board[i][j])) return false; 
        	}
        }//end of for
        for(int i=0;i<9;i++){
        	hset.clear();
        	for(int j=0;j<9;j++){
        		if(board[j][i]!='.'&&!hset.add(board[j][i])) return false; 
        	}
        }//end of for
        for(int i=0;i<9;i+=3)
        	for(int j=0;j<9;j+=3){//starting index: 3i,3j
        		hset.clear();
            	for(int m=0;m<3;m++)
            		for(int n=0;n<3;n++){
            			if(board[i+m][j+n]!='.'&&!hset.add(board[i+m][j+n])) return false; 
            		}
        		
        	}
        return true;
    }
}
