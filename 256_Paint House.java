public class Solution {
    public int minCost(int[][] costs) {
        int[] current=new int[]{0,0,0};
        int[] next=new int[]{0,0,0};
        for(int[] temp: costs){
            for(int i=0;i<3;i++)
                next[i]=Math.min(current[(i+1)%3]+temp[i],current[(i+2)%3]+temp[i]);
            int[] tempArray=current;
            current=next;
            next=tempArray;
        }
        return Math.min(Math.min(current[0],current[1]),current[2]);
    }
}
