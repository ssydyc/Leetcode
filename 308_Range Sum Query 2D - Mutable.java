public class NumMatrix {
    int[][] BIT;
    int m, n;
    
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        if (m == 0) return;
        n = matrix[0].length;
        BIT = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) Arrays.fill(BIT[i], 0);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                update(i, j, matrix[i][j]);
    }

    public void update(int row, int col, int val) {
        int diff = val - sumRegion(row, col, row, col);
        row++;
        col++;
        while (row <= m) {
            int k = col;
            while (k <= n) {
                BIT[row][k] += diff;
                k += (k & -k);
            }
            row += (row & -row);
        }
    }
    
    public int getSum(int row, int col) {
        row++;
        col++;
        int res = 0;
        while (row > 0) {
            int k = col;
            while (k > 0) {
                res += BIT[row][k];
                k -= (k & -k);
            }
            row -= (row & -row);
        }
        return res;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) - getSum(row2, col1-1) - getSum(row1-1, col2) + getSum(row1-1, col1-1);
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
