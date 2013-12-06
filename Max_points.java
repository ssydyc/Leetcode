/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
    	int result=0;
    	int max=0;
        for(int i=0; i<points.length-1;i++){
            for(int j=i+1; j<points.length;j++ ) {
            	if((points[i].x==points[j].x) && (points[i].y==points[j].y) ){;}
            		//same point, do nothing
            	else{	//check all points
            		result=0;
            		for(int k=0;k<points.length;k++){
            			int temp1=(points[k].y-points[i].y)*(points[i].x-points[j].x);	
						int temp2=(points[k].x-points[i].x)*(points[i].y-points[j].y);
						if(temp1==temp2) result++;
            		}//end of for k
    				if(result>max) max=result;        				
            	}// end of if else 
            }// end of for j
        }// end of for i
		if(max==0) max=points.length;	//all points are on the same line
        return max;
    }// int maxPoints
}// class Solution
