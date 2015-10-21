public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0||(dividend==Integer.MIN_VALUE&&divisor==-1)) return Integer.MAX_VALUE;
        long num=(long) dividend;
        long div=(long) divisor;
        int sign=1;
        if(num<0){
            num=-num;
            sign*=-1;
        }
        if(div<0){
            div=-div;
            sign*=-1;
        }
        int res=0;
        while(num>=div){
            long temp=div;
            int r=1;
            while(temp<num-temp){
                temp<<=1;
                r<<=1;
            }
            num-=temp;
            res+=r;
        }
        if(sign==-1) res=-res;
        return res;
    }
}
