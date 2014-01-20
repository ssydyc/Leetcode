
public class Longest_Palindromic_Substring {
	public String longestPalindrome(String s) {
		boolean[][] p=new boolean[s.length()][s.length()];
		return isPalindrome(s,p);
	}
	public String isPalindrome(String s,boolean p[][]) {
    	int indexi=0;
    	int indexj=0;
    	int longest=0;
		for(int j=0;j<s.length();j++)
    		for(int i=0;i<=j;i++){
    			if(j-i==1) p[i][j]=(s.charAt(i)==s.charAt(j));
    			else p[i][j]=(j-i<1)||(p[i+1][j-1]&&(s.charAt(i)==s.charAt(j)));
    			if(p[i][j]&&longest<j-i){
    				indexi=i;
    				indexj=j;
    				longest=j-i;
    			}
    		}
    	return s.substring(indexi,indexj+1);
    }//end of isPalindrome
}
