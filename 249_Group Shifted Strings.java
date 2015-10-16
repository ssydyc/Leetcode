public class Solution {
    private boolean isShift(String str1, String str2){
        if(str1.length()!=str2.length()) return false;
        if(str1.length()==0) return true;
        int difference=(int)str2.charAt(0)-(int)str1.charAt(0);
        for(int i=0;i<str1.length();i++){
            if(((int)str2.charAt(i)-(int)str1.charAt(i)!=difference)&&((int)str2.charAt(i)+26-(int)str1.charAt(i)!=difference)) return false;
        }
        return true;
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        Arrays.sort(strings);
        ArrayList<List<String>> result=new ArrayList<List<String>>();
        for(String tempString: strings){
            boolean find=false;
            for(List<String> tempList: result){
                if(tempList.size()>0 && isShift(tempList.get(0),tempString)) {
                    tempList.add(tempString);
                    find=true;
                }
            }
            if(!find){
                ArrayList<String> tempList=new ArrayList<String>();
                tempList.add(tempString);
                result.add(tempList);
            }
        }
        return result;
    }
}
