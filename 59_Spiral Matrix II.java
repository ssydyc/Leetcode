public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n == 0) return res;
        if(n == 1) {
            res[0][0] = 1;
            return res;
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0, j = 0;
        int cur = 1;
        int dir = 0;
        while(res[i][j] == 0) {
            res[i][j] = cur++;
            int tempi = i + directions[dir][0];
            int tempj = j + directions[dir][1];
            if(tempi >= 0 && tempi < n && tempj >= 0 && tempj < n && res[tempi][tempj] == 0) ;
            else {
                dir = dir + 1 > 3 ? dir - 3 : dir + 1;
                tempi = i + directions[dir][0];
                tempj = j + directions[dir][1];
            }
            i = tempi; j = tempj;
        }
        return res;
    }
}
