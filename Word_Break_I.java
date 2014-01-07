import java.util.*;


public class Word_Break_I {
	public Set<String> unmatched=new HashSet<String>();
	public boolean wordBreak(String s, Set<String> dict) {
        if(dict.contains(s)) return true;
        for(int i=0;i<s.length()-1;i++){
        	if(dict.contains(s.substring(0,i+1))&&!unmatched.contains(s.substring(i+1,s.length()))&&wordBreak(s.substring(i+1,s.length()),dict))
        			return true;
        }// end of for
        unmatched.add(s);
        return false;
    }
}
