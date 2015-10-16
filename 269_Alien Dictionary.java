class edge{
    char start;
    char end;
    public edge(char start, char end){
        this.start=start;
        this.end=end;
    }
}

public class Solution {
    
    private boolean addPair(ArrayList<edge> pair, String str1, String str2){
        int minLength=Math.min(str1.length(),str2.length());
        for(int i=0;i<minLength;i++){
            if(str1.charAt(i) != str2.charAt(i)){
                pair.add(new edge(str1.charAt(i),str2.charAt(i)));
                return true;
            }
        }
        if(str1.length()>str2.length()) return false;
        else return true;
    }
    
    // chose the one that has no precedent
    private char selectChar(HashMap<Character,Integer> count){
        for(char temp: count.keySet()){
            if(count.get(temp)<=0){
                count.remove(temp);
                return temp;
            }
        }
        return ' ';
    }
    
    private String topologicalSort(ArrayList<edge> pair){
        StringBuilder result=new StringBuilder();
        // count will record the number of precedent
        HashMap<Character,Integer> count= new HashMap<Character,Integer>();
        for(edge temp: pair){
            if(!count.containsKey(temp.start)) count.put(temp.start,0);
            if(count.containsKey(temp.end)) count.put(temp.end,count.get(temp.end)+1);
            else count.put(temp.end,1);
        }
        char choose=' ';
        while((choose=selectChar(count))!=' '){
            result.append(choose);
            // update count
            for(edge temp: pair){
                if(temp.start==choose) count.put(temp.end,count.get(temp.end)-1);
            }
        }
        if(count.isEmpty()){
            String temp= result.toString();
            if(temp.equals("")) return "$";
            else return temp;
        }
        else return "";
        
    }
    
    private String addOther(String result, String[] words){
        HashSet<Character> hasChar= new HashSet<Character>();
        StringBuilder toAdd= new StringBuilder();
        for(int i=0; i<result.length();i++){
            hasChar.add(result.charAt(i));
        }    
        for(String temp: words)
            for(int i=0;i<temp.length();i++){
                if(!hasChar.contains(temp.charAt(i))) {
                    toAdd.append(temp.charAt(i));
                    hasChar.add(temp.charAt(i));
                }
            }
        return result+toAdd.toString();
    }
    
    public String alienOrder(String[] words) {
        ArrayList<edge> pair =new ArrayList<edge>();
        for(int i=1;i<words.length;i++){
            // the case that we can't add pair
            if(!addPair(pair,words[i-1],words[i])) return "";
        }
        String result=topologicalSort(pair);
        if(result.equals("")) return "";
        else{
            if(result.equals("$")) result="";
            return addOther(result,words);
        }
        
    }
}
