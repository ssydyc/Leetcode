public class Solution{
    // Manacher's algorithm
    private char[] addBoundary(String s){
        char[] s2=new char[2*s.length()+1];
        for(int i=0;i<s.length();i++){
            s2[2*i]='|';
            s2[2*i+1]=s.charAt(i);
        }
        s2[2*s.length()]='|';
        return s2;
    }
    
    private String removeBoundary(char[] s){
        // result will have at least length 1
        char[] s2=new char[(s.length-1)/2];
        for(int i=0;i<s2.length;i++)
            s2[i]=s[2*i+1];
        return String.valueOf(s2);
    }
    
	public String longestPalindrome(String s) {
	    if(s.length()==0) return "";
	    char[] s2= addBoundary(s);
	    int[] p=new int[s2.length];
	    int c=0, r=0;
	    int m=0, n=0;
	    for(int i=1; i<s2.length;i++){
	        if(i>r){
	            p[i]=0; m=i-1; n=i+1;
	        }
	        else{
	            int i2=2*c-i;
	            if(p[i2]<r-i) {
	                p[i]=p[i2];
	                m=-1;
	            }
	            else{
	                p[i]=r-i;
	                m=2*i-r-1;
	                n=r+1;
	            }
	        }
	        // update p[i] if needed
	        while(m>=0&&n<s2.length&&s2[m]==s2[n]){
	            m--; n++; p[i]+=1;
	        }
	        if(p[i]+i>r){
	            c=i; r=p[i]+i;
	        }
	    }
	    int len=0;
	    for(int i=0;i<s2.length;i++){
	        if(p[i]>len){
	            len=p[i];
	            c=i;
	        }
	    }
	    return removeBoundary(Arrays.copyOfRange(s2,c-len,c+len+1));
	}
	
}
