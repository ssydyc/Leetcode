public class Solution {
    private boolean DFS(List<String> res,  HashMap<String, ArrayList<String>> next, int n) {
        if(n == res.size()) return true;
        ArrayList<String> toVisit = next.get(res.get(res.size() - 1));
        if(toVisit == null) return false;
        for(int i = 0; i < toVisit.size(); i++) {
            String temp = toVisit.remove(i);
            res.add(temp);
            if(DFS(res, next, n)) return true;
            toVisit.add(temp);
            Collections.sort(toVisit);
            res.remove(res.size() - 1);
        }
        return false;
    }
    
    public List<String> findItinerary(String[][] tickets) {
        int n = tickets.length;
        List<String> res = new ArrayList<String>(n);
        // Two hashTables
        HashMap<String, ArrayList<String>> next = new HashMap<String, ArrayList<String>>();
        for(String[] ticket : tickets) {
            // add to next
            if(!next.containsKey(ticket[0])) next.put(ticket[0], new ArrayList<String>());
            next.get(ticket[0]).add(ticket[1]);
        }
        // order next
        for(String tempKey : next.keySet()) {
            Collections.sort(next.get(tempKey));
        }
        res.add("JFK");
        DFS(res, next, n + 1);
        return res;
    }
}
