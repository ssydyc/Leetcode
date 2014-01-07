import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Word_Break_II {
	public Set<String> unmatched=new HashSet<String>();
	public ArrayList<String> wordBreak(String s, Set<String> dict){
        ArrayList<String> result=new ArrayList<String>();
		if(dict.contains(s)) result.add(s);
		if(unmatched.contains(s)) return result;
        for(int i=0;i<s.length()-1;i++){
        	if(dict.contains(s.substring(0,i+1))&&!unmatched.contains(s.substring(i+1,s.length()))){
        		ArrayList<String> temp=wordBreak(s.substring(i+1,s.length()),dict);
        		if(temp.isEmpty());
        		else{
        			for(String temp_s:temp){
        				result.add(s.substring(0,i+1)+' '+temp_s);
        			}
        		}
        	}//end of if
        }// end of for
        if(result.isEmpty())unmatched.add(s);
        return result;
    }
}
