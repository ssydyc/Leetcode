public class Solution {
    public int singleNumber(int[] A) {
        if(A.length==1) return A[0];
        for(int i=1;i<A.length;i++)
            A[0]=A[0]^A[i];
    return A[0];
    }
}//end of solution