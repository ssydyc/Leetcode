import java.util.*;

class Node { 
	int level;
    String val;  
    ArrayList<Node> prev=new ArrayList<Node>();            
    Node(String v,int level) {    
        this.val = v;  
        this.level=level;
    }  
}

public class Word_Ladder_II {
	ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
	Node result_node=new Node("",0);
	 public ArrayList<ArrayList<String>> findLadders(String end, String start, HashSet<String> dict) {
		int depth=finddepth(start,end,dict);
		DFS(start,result_node,depth,new ArrayList<String>());
		return result;
	  }
	
	public void DFS(String start,Node end, int depth, ArrayList<String> temp){
		depth--;
		if(depth>0){
			for(Node find_node : end.prev){
				if(find_node.val.equals(start)){
					ArrayList<String> temp1=new ArrayList<String>(temp);
					temp1.add(end.val);
					temp1.add(start);
					result.add(temp1);
					return;
				}
				else{
					ArrayList<String> temp1=new ArrayList<String>(temp);
					temp1.add(end.val);
					DFS(start,find_node,depth,temp1);
				}
			}//end of for
		}
	}
	
	public int finddepth(String start, String end, HashSet<String> dict) {
		Queue<String> BFS_q=new LinkedList<String>();
		HashMap<String,Node> map_node=new HashMap<String,Node>();
		int level=2;	//level of current search
		int depth=1;	//depth left of current level
		int current_add=0;	//number of current nodes added
		boolean found=false;	//whether we found the element
		BFS_q.add(start);
		Node start_node=new Node(start,1);
		map_node.put(start, start_node);
		while(!BFS_q.isEmpty()){
			String temp_start=BFS_q.poll();
			Node node=new Node("",0);
			node=map_node.get(temp_start);
			for(int i=0;i<temp_start.length();i++){
				char[] temp_char = temp_start.toCharArray();
				for(char j='a';j<='z';j++){
					if(temp_start.charAt(i)!=j){
						temp_char[i]=j;
						String temp_change= String.valueOf(temp_char);
						if(temp_change.equals(end)){
							if(map_node.containsKey(end)){
								map_node.get(end).prev.add(node);	//add one node for previous
							}
							else{//first time to add it
								Node temp_node=new Node(end,level);
								temp_node.prev.add(node);
								map_node.put(end, temp_node); //to get key
							}
							found=true;
						}
						else if(dict.contains(temp_change)){ //temp_change contains in dict
								
							if(map_node.containsKey(temp_change)){
								if(map_node.get(temp_change).level==level)
									map_node.get(temp_change).prev.add(node);
							}
							else{
								current_add++;
								BFS_q.add(temp_change);
								Node temp_node=new Node(temp_change,level);
								temp_node.prev.add(node);
								map_node.put(temp_change, temp_node); //to get key
							}
						}
					}//end of if
				}	
			}//end of for
			if(found&&(depth==1)) {break;}
			else if(--depth==0) {
				level++;
				depth=current_add;
				current_add=0;
			}
		}//end of while
		result_node=map_node.get(end);
		if(found) return level;
		else return 0;
	}
}//end of class
