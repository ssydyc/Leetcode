import java.util.*;

class UndirectedGraphNode {
		 int label;
		 ArrayList<UndirectedGraphNode> neighbors;
		 UndirectedGraphNode(int x) { 
			 label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
		}
}

public class Clone_graph {
	HashMap<Integer,UndirectedGraphNode> visited=new HashMap<Integer,UndirectedGraphNode>();
	HashSet<Integer> searched=new HashSet<Integer>();
	UndirectedGraphNode copy=new UndirectedGraphNode(0);
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return node;
        copy=new UndirectedGraphNode(node.label);
        visited.put(node.label, copy);
        DFS(node);
        return copy;
       
    }
	
	public void DFS(UndirectedGraphNode node){
		UndirectedGraphNode to_add=visited.get(node.label);
		searched.add(node.label);
		for(UndirectedGraphNode temp_node:node.neighbors){
			if(visited.get(temp_node.label)==null){//we didn't find the label
				UndirectedGraphNode temp=new UndirectedGraphNode(temp_node.label);
				visited.put(temp_node.label,temp);
			}
			to_add.neighbors.add(visited.get(temp_node.label));
			if(!searched.contains(temp_node.label)) DFS(temp_node);
		}
		
	}
}