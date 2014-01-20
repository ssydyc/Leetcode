import java.util.*;
public class Palindrome_Partitioning {
	HashSet<Integer[]> tested=new HashSet<Integer[]>();
	public ArrayList<ArrayList<String>> partition(String s) {
		return DFS(new StringBuffer(s).reverse().toString());
    }
	
	public ArrayList<ArrayList<String>> DFS(String s){
		ArrayList<ArrayList<String>> results=new ArrayList<ArrayList<String>>();
		ArrayList<String> temp=new ArrayList<String>();
		if(s.length()==0) {
			results.add(temp);
			return results;
		}
		if(s.length()==1) {
			results.add(temp);
			results.get(0).add(s);
			return results;
		}
		for(int i=0;i<s.length();i++){
			String temp_string=s.substring(0,i+1);
			if(isPalindrome(temp_string)){
				ArrayList<ArrayList<String>> resultsTmp=DFS(i==s.length()-1?"":s.substring(i+1));
				for(ArrayList<String> temp1: resultsTmp){
					temp1.add(temp_string);
					results.add(temp1);
				}
			}
			
		}
		return results;
		
	}
	
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
}//end of class
