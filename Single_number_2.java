public class Solution {
      
       public static int singleNumber(int[] A) {
        int[] bit_number=new int[32];
        for(int i=0;i<32;i++){
        	bit_number[i]=0;
        }
        
        for(int i=0;i<A.length;i++){
        	for(int j=0;j<32;j++){
        		if(((1<<j)&A[i])!=0) {bit_number[j]=(bit_number[j]+1)%3;}
        	}//end of for j
        }// end of for i
        
        int temp=0;
        for(int i=0;i<32;i++){
        	if(bit_number[i]!=0) {temp=temp|(1<<i);}
        }
        
        return temp;
    }





}// end of class Single_number_2