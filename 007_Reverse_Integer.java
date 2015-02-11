public class Solution {
    private int myReverse(int x){
        int result=0;
        while(x>0){
            if(result>(Integer.MAX_VALUE-x%10)/10) return 0;
            result=result*10+x%10;
            x=x/10;
        }
        return result;
    }
    
    public int reverse(int x) {
        int sign=1;
        if(x<0){
            sign=-1;
            x=-x;
        }
        return sign*myReverse(x);
    }
}
