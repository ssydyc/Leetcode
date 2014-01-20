class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

public class Sum_root_to_Leaf {
		int result;
	    public int sumNumbers(TreeNode root) {
	        result=0;
	        if(root==null) return result;
	        dosum(0,root);
	        return result;
	    }
	    
	    
	    public void dosum(int previous,TreeNode root){
	    	root.val=previous*10+root.val;
	    	if(root.left!=null) dosum(root.val,root.left);
	    	if(root.right!=null) dosum(root.val,root.right);
	    	if(root.left==null && root.right==null) result+=root.val; 
	    }
	    
	    
}//end of class
