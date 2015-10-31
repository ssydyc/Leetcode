public class Solution {
    
    private void swap(int[][] matrix, int i1, int j1, int i2, int j2){
        int temp=matrix[i1][j1];
        matrix[i1][j1]=matrix[i2][j2];
        matrix[i2][j2]=temp;
        return;
    }
    
    public void rotate(int[][] matrix) {
        int n=matrix.length-1;
        int col=n/2;
        if(n<1) return;
        int row=col-1;
        if(n%2!=0) row=col;
        for(int i=0; i<=row; i++)
            for(int j=0; j<=col; j++){
                swap(matrix, i,j, n-j, i);
                swap(matrix, n-j, i, n-i, n-j);
                swap(matrix, n-i,n-j, j, n-i);
            }
        return;
    }
}
