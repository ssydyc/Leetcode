public class Solution {
    private int longestString(String[] strs){
        int result=Integer.MAX_VALUE;
        for(String s: strs) result=Math.min(result,s.length());
        return result;
    }
    
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        int maxLength=longestString(strs);
        if(maxLength==0) return "";
        StringBuilder result=new StringBuilder("");
        for(int i=0;i<maxLength;i++){
            Character temp=strs[0].charAt(i);
            for(String tempString:strs){
                if(tempString.charAt(i)!=temp) return result.toString();
            }
            result.append(temp);
        }
        return result.toString();
    }
}
