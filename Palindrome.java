public class Solution{ 
  	public boolean isPalindrome(String s) {
    	int head=0;
    	int tail=s.length()-1;
    	while(head<tail){
    		while((head<tail)&&!Character.isDigit(s.charAt(head))&&!Character.isLetter(s.charAt(head)))
    			head++;
    		while((head<tail)&&!Character.isDigit(s.charAt(tail))&&!Character.isLetter(s.charAt(tail)))
    			tail--;
    		if(Character.isLetter(s.charAt(head))&&Character.isLetter(s.charAt(tail))){
    			if(Character.toUpperCase(s.charAt(head))!=Character.toUpperCase(s.charAt(tail)))
    				return false;
    			}
    		else{
    			if(s.charAt(head)!=s.charAt(tail)) return false;
    		}
    		head++;
    		tail--;
    	}
    	return true;
    	
    }//end of isPalindrome
}// end of Solution