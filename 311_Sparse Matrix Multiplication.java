class elem {
    public int x;
    public int y;
    public int val;
    public elem(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = B[0].length, k = B.length;
        List<elem> listA = new ArrayList<elem>();
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(res[i], 0);
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < k; j++){
                if (A[i][j] != 0) listA.add(new elem(i, j, A[i][j]));
            }
        
        for (int i = 0; i < k; i++)
            for (int j = 0; j < n; j++) {
                if (B[i][j] != 0) {
                    // iterate ocer all list A
                    for (elem temp : listA) {
                        if (temp.y == i) res[temp.x][j] += B[i][j] * temp.val;
                    }
                }
            }
        return res;
    }
}
