public class Solution {
    
    private int oneDistance(List<Integer> x){
        Collections.sort(x);
        int i=0,j=x.size()-1;
        int res=0;
        while(i<j){
            res+=Math.abs(x.get(i++)-x.get(j--));
        }
        return res;
    }
    
    public int minTotalDistance(int[][] grid) {
        List<Integer> x=new ArrayList<Integer>();
        List<Integer> y=new ArrayList<Integer>();
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    x.add(i);
                    y.add(j);
                }
            }
        return oneDistance(x)+oneDistance(y);
    }
}
