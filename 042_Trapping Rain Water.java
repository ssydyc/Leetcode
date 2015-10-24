public class Solution {
    public int trap(int[] height) {
        int res=0;
        if(height.length<3) return res;
        int[] ml=new int[height.length-2];
        ml[0]=height[0];
        for(int i=1;i<height.length-2;i++){
            ml[i]=Math.max(ml[i-1],height[i]);
        }
        int mr=Integer.MIN_VALUE;
        for(int i=height.length-2;i>0;i--){
            mr=Math.max(mr,height[i+1]);
            res+=Math.max(0,Math.min(mr,ml[i-1])-height[i]);
        }
        return res;
    }
}
