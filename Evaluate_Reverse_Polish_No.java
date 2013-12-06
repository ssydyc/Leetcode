public class Solution {
  
    public int evalRPN(String[] tokens) {
        int position=0;		
        int result=0;
        if(tokens.length==1) return Integer.parseInt(tokens[0]); 
        for(int i=0;i<tokens.length;i++){
        	if(test_numeric(tokens[i])){
        		tokens[position]=tokens[i];
        		position++;
        	}// end of if
        	
        	else{// we need two numbers at the starting point
        		int temp1=Integer.parseInt(tokens[position-1]);
        		int temp2=Integer.parseInt(tokens[position-2]);
        		position=position-2;
        		result=calculate(temp2,temp1,tokens[i]);
        		tokens[position]=Integer.toString(result);
        		position++;
        	}// end of else
        
        
        }//end of for i
    	return (int) result;
    }   //end of evalRPN
    
    
    public int calculate(int num1, int num2, String operator){
    	/** calculate num1 operator num2*/
    	if(operator.equals("+")) return (num1+num2);
    	else if(operator.equals("-")) return (num1-num2);
    	else if(operator.equals("/")) return (num1/num2);
    	else return (num1*num2);
    }	// end of calculate
    
    
    public boolean test_numeric(String test_string){
    	/** test whether it's a operator or not */
    	if(Character.isDigit(test_string.charAt(0))){
        		return true;	// add if it's a number
        }// end of if
    	else if(test_string.length()>1){
        		if(Character.isDigit(test_string.charAt(1)))
        			return true;	// add if it's a number
        }// end of if
    
    	return false;
    }	// end of test_numeric
    
}// end of Solution