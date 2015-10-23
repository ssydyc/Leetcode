public class Solution {
    public String countAndSay(int n) {
        String str="1";
        StringBuilder res= new StringBuilder();
        for(int i=1;i<n;i++){
            res.setLength(0);
            int start=0, end=0;
            while(end<str.length()){
                if(str.charAt(end)==str.charAt(start)) end++;
                else{
                    res.append(Integer.toString(end-start)+str.charAt(start));
                    start=end;
                }
            }
            res.append(Integer.toString(end-start)+str.charAt(start));
            str=res.toString();
        }
        return str;
    }
    
}
