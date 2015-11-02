public class Solution {
    
    private int[] getDirection(int direction){
        int[] res={0,0};
        if(direction%2==0)  res[1]=1;
        else res[0]=1;
        if(direction>1){
            res[0]=-res[0];
            res[1]=-res[1];
        }
        return res;
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<Integer>();
        int m=matrix.length;
        if(m==0) return res;
        int n=matrix[0].length;
        int cur_x=0, cur_y=-1;
        int direction=0;
        boolean flagm=true;
        while(m>0 && n>0){
            int temp=0;
            if(flagm) temp=n;
            else temp=m;
            int[] dir= getDirection(direction);
            for(int i=0;i<temp;i++){
                cur_x+=dir[0];
                cur_y+=dir[1];
                res.add(matrix[cur_x][cur_y]);
            }
            if(++direction>=4) direction-=4;
            if(flagm) m--;
            else n--;
            flagm=!flagm;
        }
        return res;
    }
}
