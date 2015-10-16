public class Solution {
    
    private void DFS(List<List<Integer>> result, LinkedList<Integer> temp, int n, int min){
        if(temp.size()>0){
            temp.add(n);
            result.add(new LinkedList(temp));
            temp.removeLast();
        }
        
        for(int i=min;i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
                temp.add(i);
                DFS(result,temp,n/i,i);
                temp.removeLast();
            }
        }
    }
    
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        LinkedList<Integer> temp= new LinkedList<Integer>();
        DFS(result,temp,n,2);
        return result;
    }
}
