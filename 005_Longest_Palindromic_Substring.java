public class Solution {
    
    private int[] maxOdd(String s, int i){
        // if there is odd number of palindromic Substring
        
        int start=i-1;
        int end=i+1;
        int maxLength=1;
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            maxLength+=2;
        }
        int[] result={maxLength,start+1,end-1}; // First the maximum length, second the start, third end
        return result;
    }
    
    private int[] maxEven(String s, int i){
        // if there is odd number of palindromic Substring
        int start=i;
        int end=i+1;
        int maxLength=0;
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            maxLength+=2;
        }
        int[] result={maxLength,start+1,end-1}; // First the maximum length, second the start, third end
        return result;
    }
    
    
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";
        int[] maxLength={1,0,0}; 
        for(int i=0;i<s.length();i++){
            int[] temp1=maxOdd(s,i);
            int[] temp2=maxEven(s,i);
            if(temp1[0]>maxLength[0]) maxLength=temp1;
            if(temp2[0]>maxLength[0]) maxLength=temp2;
        }
        return s.substring(maxLength[1],maxLength[2]+1);
    }
}
