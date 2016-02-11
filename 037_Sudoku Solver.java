public class Solution {
    private void findNext(int[] cur, char[][] board) {
        do {
            cur[1]++;
            if(cur[1] > 8) {
                cur[1] = 0;
                cur[0] ++ ;
            }
        } while (cur[0] < 9 && board[cur[0]][cur[1]] != '.');
        return;
    }
   
    private boolean helper(char[][] board, int[] cur) {
        int[] temp = {cur[0], cur[1]};
        findNext(cur, board);
        if(cur[0] == 9) return true; // we have reached the end
        boolean[] possible = new boolean[9];
        Arrays.fill(possible, true);
        for(int i = 0; i < 9; i++)
            if(board[i][cur[1]] != '.') possible[board[i][cur[1]] - '1'] = false;
        for(int i = 0; i < 9; i++)
            if(board[cur[0]][i] != '.') possible[board[cur[0]][i] - '1'] = false;
        int tempi = cur[0] / 3 * 3, tempj = cur[1] / 3 * 3;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) 
                if(board[tempi + i][tempj + j] != '.') possible[board[tempi + i][tempj + j] - '1'] = false;
        for(int i = 0; i < 9; i++) {
            if(possible[i]) {
                board[cur[0]][cur[1]] = (char) ((int) '1' + i);
                if(helper(board, cur)) return true;
            }
        }
        board[cur[0]][cur[1]] = '.';
        cur[0] = temp[0];
        cur[1] = temp[1];
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        int[] cur = {0, -1};
        helper(board, cur);
        return;
    }
}
