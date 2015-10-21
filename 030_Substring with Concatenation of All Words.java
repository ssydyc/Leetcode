public class Solution {
    
    private void initialize(HashMap<String,Integer> hm, HashMap<String,Integer> hm1){
        for(String key: hm.keySet()){
            hm1.put(key, hm.get(key));
        }
    }
    
    private boolean isEqual(String s,int i, String[] words, HashMap<String,Integer> hm1){
        int k=words[0].length();
        for(int j=0; j<words.length;j++){
            String temp=s.substring(i+j*k,i+j*k+k);
            if(hm1.containsKey(temp)){
                hm1.put(temp,hm1.get(temp)-1);
                if(hm1.get(temp)==0) hm1.remove(temp);
            }
            else return false;
        }
        
        if(hm1.size()==0) return true;
        return false;
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        HashMap<String,Integer> hm1=new HashMap<String,Integer>();
        List<Integer> res=new ArrayList<Integer>();
        if(words.length==0) return res;
        int total=words.length*words[0].length();
        for(String temp: words){
            if(!hm.containsKey(temp)) hm.put(temp,1);
            else hm.put(temp,hm.get(temp)+1);
        }
        
        for(int i=0;i<=s.length()-total;i++){
            initialize(hm,hm1);
            if(isEqual(s,i, words, hm1)) res.add(i);
        }
        return res;
    }
}
