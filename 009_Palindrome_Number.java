public class Solution {
    private boolean positivePalindrome(int x){
        int y=0;
        while(y<x){
            y=y*10+x%10;
            x=x/10;
        }
        if(y==x || (y-10*x<10 && y-10*x>-10)) return true;
        return false;
    }
    
    
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;
        if(x%10==0) return false; 
        return positivePalindrome(x);
    }
}
