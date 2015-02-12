public class Solution {

    private String trimSpace(String str){
        // trim the front spaces
        int i=0;
        for(i=0;i<str.length();i++){
            if(str.charAt(i)!=' ') break;
        }
        return str.substring(i);
    }
    
    private int sign(String str){
        if(str.charAt(0)=='+') return 1;
        else if(str.charAt(0)=='-') return -1;
        else return 0;
    }
    
    private int Convert(String str, int resultSign){
        int result=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>'9' || str.charAt(i)<'0') break;
            if(resultSign==1 && result>(Integer.MAX_VALUE-(str.charAt(i)-'0'))/10) return Integer.MAX_VALUE;
            if(resultSign==-1 && -result<(Integer.MIN_VALUE+(str.charAt(i)-'0'))/10) return Integer.MIN_VALUE;
            result=result*10+(str.charAt(i)-'0');
        }
        return resultSign*result;
    }
    
    
    public int atoi(String str) {
        if(str.length()==0) return 0;
        str=trimSpace(str);
        int resultSign=sign(str);
        if(resultSign!=0){
            str=str.substring(1);
        }
        else resultSign=1;
        return Convert(str,resultSign);
        
    }
        
}
