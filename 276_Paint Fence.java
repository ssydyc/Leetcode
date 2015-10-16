public class Solution {
    public int numWays(int n, int k) {
        if(n==0|| k==0) return 0;
        int[] current= new int[3]{k,k,k};
        int[] pre=new int[3]{k,k,k};
        for(int i=1;i<n;i++){
            current[0]=pre[0]*(k-1);
            current[1]=current[0]+pre[0]
        }
    }
}
