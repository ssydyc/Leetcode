public class Solution {
    private int minimumWithExclusion(int[] array, int k){
        int result=Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++){
            if(i!=k) result=Math.min(result,array[i]);
        }
        return result;
    }
    
    public int minCostII(int[][] costs) {
        if(costs.length==0) return 0;
        for(int i=1;i<costs.length;i++)
            for(int j=0;j<costs[0].length;j++){
                costs[i][j]=costs[i][j]+minimumWithExclusion(costs[i-1],j);
            }
        return minimumWithExclusion(costs[costs.length-1],-1);
    }
}
