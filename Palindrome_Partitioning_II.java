import java.util.*;
public class Palindrome_Partitioning_II {
	HashMap<Integer,Integer> calculated=new HashMap<Integer,Integer>();
	public int minCut(String s) {
		boolean[][] p=new boolean[s.length()][s.length()];
		isPalindrome(s,p);
		return DFS(0,s,p);
    }
	
	public int DFS(int start, String s,boolean[][] p){
		if(s.length()==0) {
			calculated.put(0, -1);
			return -1;
		}
		if(s.length()==1) {
			calculated.put(1, 0);
			return 0;
		}
		int min=s.length()-1;
		for(int i=s.length()-1;i>=0;i--){
			if(p[start][start+i]){
				if(calculated.containsKey(s.length()-i-1)){
					int temp=calculated.get(s.length()-i-1);
					min=Math.min(min, 1+temp);
				}
				else{
					int temp=DFS(start+i+1,s.substring(i+1),p);
					min=Math.min(min, 1+temp);
				}
			}
		}
		calculated.put(s.length(),min);
		return min;	
	}
	public void isPalindrome(String s,boolean p[][]) {
    	for(int j=0;j<s.length();j++)
    		for(int i=0;i<=j;i++){
    			if(j-i<1)p[i][j]=true;
    			else if(j-i==1) p[i][j]=(s.charAt(i)==s.charAt(j));
    			else p[i][j]=(p[i+1][j-1]&&(s.charAt(i)==s.charAt(j)));
    		}
    	
    }//end of isPalindrome
}//end of class

