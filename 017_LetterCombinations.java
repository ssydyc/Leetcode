public class Solution {
    private String oneLetter(char s){
        // return the corresponding letters of the number
        if(s=='9') return "wxyz";
        if(s=='7') return "pqrs";
        if(s=='8') return "tuv";
        else{
            int temp_start=(s-'2')*3+(int)'a';
            String result="";
            for(int i=0;i<=2;i++){
                result+= (char)(temp_start+i);
            }
            return result;
        } 
    }
    
    private List<String> combineStrings(List<String> stringList, String oneLetter){
        List<String> result=new ArrayList<String>();
        for(int i=0;i<oneLetter.length();i++){
            for(String s:stringList){
                result.add(oneLetter.charAt(i)+s);
            }
        }
        return result;
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<String>();
        if(digits.length()==0) return result;
        if(digits.length()==1){
            String temp=oneLetter(digits.charAt(0));
            for(int i=0;i<temp.length();i++){
                result.add(String.valueOf(temp.charAt(i)));
            }
            return result;
        }    
        List<String> tempSubproblem=letterCombinations(digits.substring(1));
        String tempOneLetter=oneLetter(digits.charAt(0));
        return combineStrings(tempSubproblem,tempOneLetter);
        
    }
}
