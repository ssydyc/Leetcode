import java.util.*;

public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
    	if(matrix.length==0) return 0;
        int[][] height=new int[matrix.length][matrix[0].length];	//store height information
  		for(int column=0;column<matrix[0].length;column++){
  			int i=0,j=0;					//i,j point to the beginning
  			while(j<matrix.length){
  				while(j<matrix.length&&matrix[j][column]!='1'){
  					j++;
  				}//end of while, j points to '1'
  				while(i<j){
  					height[i][column]=0;		// 0 itself, thus set height to 0
  					i++;
  				}
  				while(j<matrix.length&&matrix[j][column]=='1'){
  					j++;
  				}	// now j points to '0' or end
  				while(i<j){
  					height[i][column]=j-i;
  					i++;
  				}
  			}//end of while
  		}// for each row, calculate the maximum height
  		int maxArea=0;
		for(int row=0;row<matrix.length;row++){
			maxArea=Math.max(maxArea,largestRectangleArea(height[row]));
		}
   		return maxArea;
   }
    
    
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
          int i = 0;
          int maxArea = 0;
          int[] h = new int[height.length + 1];
          h = Arrays.copyOf(height, height.length + 1);
          while(i < h.length){
              if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                  stack.push(i++);
             }else {
                 int t = stack.pop();
                 maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
             }
         }
         return maxArea;
    }
    
}//end of Maximal_Rectangle