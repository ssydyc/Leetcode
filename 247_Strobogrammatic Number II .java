public class Solution {
    
    private List<String> helper(int n, int m){
        if(n==0) return new ArrayList<String>(Arrays.asList(""));
        if(n==1) return new ArrayList<String>(Arrays.asList("0","1","8"));
        ArrayList<String> result=new ArrayList<String>();
        for(String temp: helper(n-2,m)){
            if(n!=m) result.add("0"+temp+"0");
            result.add("1"+temp+"1");
            result.add("8"+temp+"8");
            result.add("6"+temp+"9");
            result.add("9"+temp+"6");
        }
        return result;
    }
    
    public List<String> findStrobogrammatic(int n) {
        return helper(n,n);
        
    }
}
