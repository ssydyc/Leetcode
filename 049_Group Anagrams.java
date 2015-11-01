public class Solution {
    
    private String getKey(String str){
        char[] temp=str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        HashMap<String, Integer> index= new HashMap<String, Integer>();
        List<List<String>> res= new ArrayList<List<String>>();
        for(String temp: strs){
            String key= getKey(temp);
            if(!index.containsKey(key)){
                index.put(key,res.size());
                List<String> temp1= new LinkedList<String>();
                temp1.add(temp);
                res.add(temp1);
            }
            else{
                int ind= index.get(key);
                res.get(ind).add(temp);
            }
        }
        return res;
    }
}
