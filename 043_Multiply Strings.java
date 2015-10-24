public class Solution {
    private int mul(char num1, char num2){
        return ((int)num1-(int)'0')*((int)num2-(int)'0');
    }
    
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        int[] res= new int[num1.length()+num2.length()];
        Arrays.fill(res,0);
        for(int i=0;i<len1;i++)
            for(int j=0;j<len2;j++){
                res[i+j]+=mul(num1.charAt(len1-1-i),num2.charAt(len2-1-j));
            }
        int carry=0;
        for(int i=0;i<res.length;i++){
            res[i]+=carry;
            carry=res[i]/10;
            res[i]%=10;
        }
        int end=res.length-1;
        while(end>=0 && res[end]==0)end--;
        if(end<0) return "0";
        StringBuilder res2=new StringBuilder(res.length);
        for(int i=end;i>=0;i--){
            res2.append((char)(res[i]+ (int)'0'));
        }
        return res2.toString();
    }
}
