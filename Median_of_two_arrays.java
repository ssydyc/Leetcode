public class Solution {
   
    public static double findMedianSortedArrays(int A[], int B[]) {
        if(A.length==0){
        	if((B.length%2)==1) return (double)B[B.length/2];
        	else return (double)(B[B.length/2-1]+B[B.length/2])/2;
        }
        if(B.length==0){
        	if((A.length%2)==1) return (double)A[A.length/2];
        	else return (double)(A[A.length/2-1]+A[A.length/2])/2;
        }
        if(A.length==1) return length_1_case(A,B);
       	if(B.length==1) return length_1_case(B,A);
        //now we go to normal case
        if(A.length==2) return length_2_case(A,B);
        if(B.length==2)	return length_2_case(B,A);
        if(median(A)==median(B)) return median(A);
        if(median(A)<median(B)){
        	int cut=Math.min(A.length/2,B.length/2)-1; // the number of elements to cut
        	if((A.length==3)||(B.length==3)) cut=1;
        	int[] Anew=new int[A.length-cut];
        	int[] Bnew=new int[B.length-cut];
      		System.arraycopy(A,cut,Anew,0,A.length-cut);
      		System.arraycopy(B,0,Bnew,0,B.length-cut);
      		return findMedianSortedArrays(Anew,Bnew);
        }
        else{	//median(A)>median(B)
        	int cut=Math.min(A.length/2,B.length/2)-1; // the number of elements to cut
        	if((A.length==3)||(B.length==3)) cut=1;
        	int[] Anew=new int[A.length-cut];
        	int[] Bnew=new int[B.length-cut];
      		System.arraycopy(A,0,Anew,0,A.length-cut);
      		System.arraycopy(B,cut,Bnew,0,B.length-cut);
      		return findMedianSortedArrays(Anew,Bnew);
        }
    }// end of findMedianSortedArrays
    
    public static double length_1_case(int A[], int B[]){
    	if((B.length%2)==0){
        		if(A[0]<B[B.length/2-1]) {return (double)B[B.length/2-1];}
        		else if(A[0]>B[B.length/2]) {return (double)B[B.length/2];}
        		else {return (double)A[0];}
   		 }
        else{ // length of B is odd
        	if(B.length==1) {return (double)(A[0]+B[0])/2;} //B has length one, different story
        	if(A[0]>B[B.length/2+1]) {return ((double)(B[B.length/2]+B[B.length/2+1]))/2;}
        	if(A[0]<B[B.length/2-1]) {return ((double)(B[B.length/2-1]+B[B.length/2]))/2;}
        	else{
        	double temp=(double)(B[B.length/2]+A[0])/2;
        	return temp;
        	}
        }
    }
    
    public static double length_2_case(int A[], int B[]){
    	// length of A is two
    	if(B.length%2==1){
    		if((A[0]<=B[B.length/2])&&(A[1]<=B[B.length/2])) {return Math.max((double)B[B.length/2-1],(double)A[1]);}
    		else if((A[0]>=B[B.length/2])&&(A[1]>=B[B.length/2])) {return Math.min((double)B[B.length/2+1],(double)A[0]);}
    		else {return (double)B[B.length/2];}
    	}
    	else{		//length of B is even
    		if((B.length==2)&&B[0]>A[A.length/2-1]&&B[1]<A[A.length/2]) {return (double)(B[0]+B[1])/2;}
    		if(A[0]>B[B.length/2-1]&&A[1]<B[B.length/2]) {return (double)(A[0]+A[1])/2;}
    		else{
    			if(median(A)<median(B)){
        			int cut=1; // the number of elements to cut
        			int[] Anew=new int[A.length-cut];
        			int[] Bnew=new int[B.length-cut];
      				System.arraycopy(A,cut,Anew,0,A.length-cut);
      				System.arraycopy(B,0,Bnew,0,B.length-cut);
      				return findMedianSortedArrays(Anew,Bnew);
       			}
       			else{	//median(A)>median(B)
        			int cut=1; // the number of elements to cut
        			int[] Anew=new int[A.length-cut];
        			int[] Bnew=new int[B.length-cut];
      				System.arraycopy(A,0,Anew,0,A.length-cut);
      				System.arraycopy(B,cut,Bnew,0,B.length-cut);
      				return findMedianSortedArrays(Anew,Bnew);
        		}
    		 		
    		}
    	}
    
    }// end of length_2_case
    
    
    
    public static double median(int A[]){
    	if((A.length%2)==1) {return (double)A[A.length/2];}
    	else {return ((double)(A[A.length/2-1]+A[A.length/2]))/2.;}
    }
    
    
    
}// end of class Median of two arrays