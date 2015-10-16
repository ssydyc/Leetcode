public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result= new ArrayList<String>();
        StringBuilder stringS= new StringBuilder(s);
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)=='+'&& s.charAt(i-1)=='+'){
                stringS.setCharAt(i-1, '-');
                stringS.setCharAt(i,'-');
                result.add(stringS.toString());
                stringS.setCharAt(i-1, '+');
                stringS.setCharAt(i,'+');
            }
        }
        return result;
    }
}
