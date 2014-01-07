
public class Palindrome_Number {
	public boolean isPalindrome(int x) {
        if(x==Math.pow(-2,31)) return false;
        if(x<0) return false;
        int div=1;
        while(x/div>=10) div*=10;
        while(div>=10){
        	if(x%10==x/div);
        	else return false;
        	x=(x-x%10*div)/10;
        	div/=100;
        }//end of while
        return true;
	}
}
