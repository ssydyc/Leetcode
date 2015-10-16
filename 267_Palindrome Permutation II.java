public class Solution {
    
    private void helper(String candidate, ArrayList<Character> keys, HashMap<Character, Integer> count, LinkedList<String> result){
        boolean change=false;
        for(char temp: keys){
            if(count.get(temp)>=2){
                //String toAdd=String.valueOf(temp);
                count.put(temp,count.get(temp)-2);
                helper(temp+candidate+temp,keys, count, result);
                count.put(temp,count.get(temp)+2);
                change=true;
            }
        }
        if(!change) result.add(candidate);
        return;
    }
    
    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> count= new HashMap<Character, Integer>();
        ArrayList<Character> keys=new ArrayList<Character>();
        LinkedList<String> result=new LinkedList<String>();
        for(int i=0; i<s.length(); i++){
            char temp=s.charAt(i);
            if(!count.containsKey(temp)){
                count.put(temp,1);
                keys.add(temp);
            }    
            else count.put(temp,count.get(temp)+1);
        }
        char singleIndex=' ';
        for(char temp: keys){
            if(count.get(temp)%2!=0){
                // the case of empty palindrome
                if(singleIndex!=' ') return result;
                else singleIndex=temp;
            }
        }
        String candidate;
        if(singleIndex==' ') candidate="";
        else {
            candidate=String.valueOf(singleIndex);
            count.put(singleIndex,count.get(singleIndex)-1);
        }
        helper(candidate, keys, count, result);
        return result;
    }
}
