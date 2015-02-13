public class Solution {
    private int area(int[] height,int start,int end){
        return Math.min(height[start],height[end])*(end-start);
    }
    
    public int maxArea(int[] height) {
        if(height.length<=1) return 0;
        int start=0;
        int end=height.length-1;
        int result=0;
        while(start!=end){
            result=Math.max(result,area(height,start,end));
            if(height[start]>=height[end]) end--;
            else start++;
        }
        return result;
        
    }    
    
