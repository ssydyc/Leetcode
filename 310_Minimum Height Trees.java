public class Solution {
    
    private List<Integer> findEdge(HashMap<Integer, Integer> count) {
        List<Integer> res =new ArrayList<Integer>();
        for(int temp : count.keySet()) {
            if(count.get(temp) == 0) res.add(temp);
        }
        return res;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> listEdges = new ArrayList<List<Integer>>(n);
        List<Integer> res = new ArrayList<Integer>();
        if(n == 1) {
            res.add(0);
            return res;
        }
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>(n);
        for(int i = 0; i < n; i++) listEdges.add(new ArrayList<Integer>(2));
        for(int[] temp : edges) {
            for(int i = 0; i < 2; i++) {
                listEdges.get(temp[i]).add(temp[(i + 1) % 2]);
                if(count.containsKey(temp[i])) count.put(temp[i], count.get(temp[i]) + 1);
                else count.put(temp[i], 0);
            }
        }
        // now remove leafs one by one
        while(count.size() > 2) {
            List<Integer> toRemove = findEdge(count);
            for(int temp : toRemove) {
                count.remove(temp);
                for(int temp2 : listEdges.get(temp)) {
                    if(count.containsKey(temp2)) count.put(temp2, count.get(temp2) - 1);
                }   
            }
        }
        res.addAll(count.keySet());
        return res;
    }
}
