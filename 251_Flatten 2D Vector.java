public class Vector2D {
    private ArrayList<ArrayList<Integer>> vector=new ArrayList<ArrayList<Integer>>();
    int i,j;
    
    public Vector2D(List<List<Integer>> vec2d) {
        for(List<Integer> tempList: vec2d){
            ArrayList<Integer> listToAdd=new ArrayList<Integer>();
            for(Integer temp: tempList) listToAdd.add(temp);
            vector.add(listToAdd);
        }
        i=0; j=-1;
    }

    private int[] nextIndex(int i, int j){
        j++;
        while(i<vector.size() && vector.get(i).size()<=j){
            i++; j=0;
        }
        return new int[]{i,j};
    }
    
    public int next() {
        int[] result=nextIndex(i,j);
        i=result[0];
        j=result[1];
        return vector.get(i).get(j);
    }

    public boolean hasNext() {
        int[] result=nextIndex(i,j);
        if(result[0]>=vector.size()) return false;
        else return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
