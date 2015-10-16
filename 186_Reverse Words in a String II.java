public class Solution {
    
    private void reverseTotal(char[] s, int start, int end){
        while(start<end){
            char temp=s[start];
            s[start++]=s[end];
            s[end--]=temp;
        }
        return;
    }
    
    public void reverseWords(char[] s) {
        reverseTotal(s,0,s.length-1);
        int start=0,end=0;
        while(end<s.length){
            if(s[end]==' ') {
                reverseTotal(s, start, end-1);
                start=end+1;
            }
            end++;
        }
        reverseTotal(s,start,end-1);
        return;
        
    }
}
