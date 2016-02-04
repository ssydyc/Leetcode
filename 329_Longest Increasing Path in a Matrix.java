public class Solution {
    
    private int DFS(int[][] matrix, int i, int j, int[][] cache) {
         if(cache[i][j] > 0) return cache[i][j];
         int res = 1;
         int m = matrix.length, n = matrix[0].length;
         int temp;
         if(i > 0 && matrix[i - 1][j] < matrix[i][j]) {
             if(cache[i - 1][j] > 0) temp = cache[i - 1][j];
             else temp = DFS(matrix, i - 1, j, cache);
             if(temp + 1 > res) res = temp + 1;
         }
         if(i < m - 1 && matrix[i + 1][j] < matrix[i][j]) {
             if(cache[i + 1][j] > 0) temp = cache[i + 1][j];
             else temp = DFS(matrix, i + 1, j, cache);
             if(temp + 1 > res) res = temp + 1;
         }
         if(j > 0 && matrix[i][j - 1] < matrix[i][j]) {
             if(cache[i][j - 1] > 0) temp = cache[i][j - 1];
             else temp = DFS(matrix, i, j - 1, cache);
             if(temp + 1 > res) res = temp + 1;
         }
         if(j < n - 1 && matrix[i][j + 1] < matrix[i][j]) {
             if(cache[i][j + 1] > 0) temp = cache[i][j + 1];
             else temp = DFS(matrix, i, j + 1, cache);
             if(temp + 1 > res) res = temp + 1;
         }
         cache[i][j] = res;
         return res;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int res = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                int temp = DFS(matrix, i, j, cache);
                if(temp > res) res = temp;
            }
        return res;
    }
}
