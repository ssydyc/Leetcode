import java.util.HashSet;

public class Longest_Consecutive_Sequence {
	public int longestConsecutive(int[] num) {
		HashSet<Integer> find_number=new HashSet<Integer>();
		for(int temp:num){
			find_number.add(temp);
		}
		int max=0;
		for(int temp:num){
			if(!find_number.contains(temp));
			else{
				int current=1;
				int temp1=temp;
				while(find_number.remove(--temp1)) current++;
				temp1=temp;
				while(find_number.remove(++temp1)) current++;
				if(current>max) max=current; 
			}//end ifelse
		}
		return max;
    }
}
