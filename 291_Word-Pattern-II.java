public class Solution {
    
    private boolean compare(String str, String str2){
        if(str2.length()>str.length()) return false;
        for(int i=0;i<str2.length();i++)
            if(str.charAt(i)!=str2.charAt(i)) return false;
        return true;
    }
    
    private boolean helper(String pattern, String str, HashMap<Character, String> mapPattern,HashSet<String> keys){
        if(pattern.length()> str.length()) return false;
        if(pattern.length()==0){
            if(pattern.length()==str.length()) return true;
            else return false;
        }
        String nextPattern=pattern.substring(1,pattern.length());
        char cur=pattern.charAt(0);
        // if char is contained in the hashMap
        if(mapPattern.containsKey(cur)){
            String temp=mapPattern.get(cur);
            if(compare(str, temp))
                return helper(nextPattern, str.substring(temp.length()), mapPattern,keys);
            else return false;
        }
        // if not contained
        boolean result=false;
        for(int i=1; i<=str.length();i++){
            String temp=str.substring(0,i);
            if(keys.contains(temp)) continue; // the string already mapped
            else{
                mapPattern.put(cur,temp);
                keys.add(temp);
                result=helper(nextPattern, str.substring(i),mapPattern,keys);
                mapPattern.remove(cur);
                keys.remove(temp);
                if(result) break;
            }
        }
        return result;
    }
    
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> mapPattern= new HashMap<Character,String>();
        HashSet<String> keys= new HashSet<String>();
        return helper(pattern, str, mapPattern,keys);
    }
}
