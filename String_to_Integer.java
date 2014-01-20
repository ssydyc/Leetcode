public class String_to_Integer {
    public int atoi(String str) {
        long result=0;
        int sign=1;
        int i=0;
        if(str.length()==0) return 0;
        while(i<str.length()&&str.charAt(i)==' ') i++;
        if(str.charAt(i)=='-') {sign=-1;i++;}
        else if(str.charAt(i)=='+') i++;
        while(i<str.length() && str.charAt(i)<='9'&& str.charAt(i)>='0'){
        	int temp=str.charAt(i)-'0';
        	result=result*10+temp;
        	if(sign==-1 && -result<-2147483648) return -2147483648;
        	else if(sign==1 && result>2147483647) return 2147483647;
        	i++;
        }
        return sign*(int)result;
    }
}