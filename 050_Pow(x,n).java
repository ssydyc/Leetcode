public class Solution {
    public double myPow(double x, int n) {
        double res=1;
        boolean negative=(n<0);
        if(negative) n=-n;
        while(n>0){
            if((n&1)!=0) res*=x;
            n=n>>1;
            x=x*x;
        }
        if(negative) res=1/res;
        return res;
    }
}
