import java.util.*;

public class Word_Ladder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
      return BFS(start,end,dict);
    }
	
	public int BFS(String start, String end, HashSet<String> dict){
		Queue<String> BFS_q=new LinkedList<String>();
		BFS_q.add(start);
		int size=start.length();
		int level=2;	//level of current search
		int depth=1;	//depth left of current level
		int current_add=0;	//number of current nodes added
		while(!BFS_q.isEmpty()){
			String temp_start=BFS_q.poll();
			if(Hamming_d(temp_start,end)==1) return level;
			for(int i=0;i<temp_start.length();i++){
				for(char j='a';j<='z';j++){
					String temp_change=temp_start;
					if(temp_start.charAt(i)!=j){
						if(i==0) temp_change=j+temp_start.substring(1,size);
						else if(i==size-1)	temp_change=temp_start.substring(0,size-1)+j;
						else temp_change=temp_start.substring(0,i)+j+temp_start.substring(i+1,size);
						if(dict.contains(temp_change)){
							BFS_q.add(temp_change);
							current_add++;
							dict.remove(temp_change);
						}
					}//end of if
				}	
			}//end of for
			if(--depth==0) {level++;depth=current_add;current_add=0;}
		}//end of while
		return 0;
	}
	
	public int Hamming_d(String start, String end){
		int result=0;
		for(int i=0;i<start.length();i++){
			if(start.charAt(i)!=end.charAt(i)) result++;
		}
		return result;
	}
	
}//end of class
