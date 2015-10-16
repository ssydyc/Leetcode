public class Solution {
    int result;

    private boolean GreaterEqual(String str1, String str2){
        if(str1.length()>str2.length()) return true;
        else if(str1.length()<str2.length()) return false;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i) > str2.charAt(i)) return true;
            else if(str1.charAt(i) < str2.charAt(i)) return false;
        }
        // the case of equal
        return true;
    }
    
    
    private ArrayList<String> helpStrobogrammatic(String low, String high, int n){
        if(n==0) return new ArrayList<String>(Arrays.asList(""));
        if(n==1) {
            if(GreaterEqual(high,"0") && GreaterEqual("0",low)) result++;
            if(GreaterEqual(high,"1") && GreaterEqual("1",low)) result++;
            if(GreaterEqual(high,"8") && GreaterEqual("8",low)) result++;
            return new ArrayList<String>(Arrays.asList("0","1","8"));
        }
        ArrayList<String> resultList=new ArrayList<String>();
        for(String temp: helpStrobogrammatic(low, high, n-2)){
            String addTemp="";
            resultList.add("0"+temp+"0");
            addTemp="1"+temp+"1";
            if(GreaterEqual(high,addTemp) && GreaterEqual(addTemp,low)) result++;
            resultList.add(addTemp);
            addTemp="8"+temp+"8";
            if(GreaterEqual(high,addTemp) && GreaterEqual(addTemp,low)) result++;
            resultList.add(addTemp);
            addTemp="6"+temp+"9";
            if(GreaterEqual(high,addTemp) && GreaterEqual(addTemp,low)) result++;
            resultList.add(addTemp);
            addTemp="9"+temp+"6";
            if(GreaterEqual(high,addTemp) && GreaterEqual(addTemp,low)) result++;
            resultList.add(addTemp);
        }
        return resultList;
    }  
    
    public int strobogrammaticInRange(String low, String high) {
        result=0;
        helpStrobogrammatic(low, high, high.length());
        if(low.length()!=high.length()) helpStrobogrammatic(low, high, high.length()-1);
        return result;
    }
}
