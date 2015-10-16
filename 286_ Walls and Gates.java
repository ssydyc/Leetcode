class coordinate{
    int x;
    int y;
    public coordinate(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Solution {
    
    private void update(int x, int y,  Queue<coordinate> q1, int level, int[][] rooms){
        if(x<0|| x>=rooms.length ||y<0|| y>=rooms[0].length|| rooms[x][y]<level) return;
        rooms[x][y]=level;
        q1.offer(new coordinate(x,y));
        return;
    }
    
    private void BFS(int i, int j, int[][] rooms){
        int level=0;
        Queue<coordinate> q1= new LinkedList<coordinate>();
        q1.offer(new coordinate(i,j));
        while(!q1.isEmpty()){
            level++;
            int temp=q1.size();
            for(int k=0;k<temp;k++){
                coordinate cur=q1.poll();
                update(cur.x-1,cur.y,q1,level,rooms);
                update(cur.x,cur.y-1,q1,level,rooms);
                update(cur.x+1,cur.y,q1,level,rooms);
                update(cur.x,cur.y+1,q1,level,rooms);
            }    
        }
        return;
    }
    
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length==0) return;
        boolean[][] flag= new boolean[rooms.length][rooms[0].length];
        for(int i=0; i<rooms.length;i++)
            for(int j=0; j<rooms[0].length;j++){
                if(rooms[i][j]==0) BFS(i,j,rooms);
            }
        return;
    }
}
