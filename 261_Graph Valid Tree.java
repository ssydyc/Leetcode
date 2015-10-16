public class Solution {
    
    private boolean BFS(int[][] edges, boolean[] visitedEdge, boolean[] visitedNode){
        Queue<Integer> Nodeq= new LinkedList<Integer>();
        Nodeq.offer(0);
        visitedNode[0]=true;
        while(!Nodeq.isEmpty()){
            for(int i=0; i<Nodeq.size();i++){
                int temp=Nodeq.poll();
                for(int j=0;j<edges.length;j++){
                    if(!visitedEdge[j]){
                        if(edges[j][0]==temp){
                            Nodeq.offer(edges[j][1]);
                            if(!visitedNode[edges[j][1]]) visitedNode[edges[j][1]]=true;
                            else return false;
                            visitedEdge[j]=true;
                        }
                        else if(edges[j][1]==temp){
                            Nodeq.offer(edges[j][0]);
                            if(!visitedNode[edges[j][0]]) visitedNode[edges[j][0]]=true;
                            else return false;
                            visitedEdge[j]=true;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public boolean validTree(int n, int[][] edges){
        if(edges.length!=n-1) return false;
        boolean[] visitedEdge=new boolean[edges.length];
        boolean[] visitedNode=new boolean[n];
        Arrays.fill(visitedEdge,false);
        Arrays.fill(visitedNode,false);
        return BFS(edges,visitedEdge,visitedNode);
    }
}
