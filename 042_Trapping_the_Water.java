public class Solution {
    private int[] maxLeft(int[] A){
        int[] result=new int[A.length];
        result[0]=0;
        for(int i=1;i<A.length;i++){
            result[i]=Math.max(result[i-1],A[i-1]);
        }
        return result;
    }
    
    private int[] maxRight(int[] A){
        int[] result=new int[A.length];
        result[A.length-1]=0;
        for(int i=A.length-2;i>=0;i--){
            result[i]=Math.max(result[i+1],A[i+1]);
        }
        return result;
    }
    
    private int calculate(int[] A,int[] Left,int[] Right){
        int result=0;
        for(int i=0;i<A.length;i++){
            result+=Math.max(Math.min(Left[i],Right[i])-A[i],0);
        }
        return result;
    }
    
    public int trap(int[] A) {
        if(A.length<=1) return 0;
        return calculate(A, maxLeft(A),maxRight(A));
    }
}
