public class Binary_tree_Postorder{
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 	private ArrayList<Integer> result=new ArrayList<Integer>(); 
 	
 	
    public ArrayList<Integer> postorderTraversal(TreeNode root){
    	if(root==null) return result;
		Do_recurse(root);
		return result;
    }

	public void Do_recurse(TreeNode root){
		if(root.left!=null) postorderTraversal(root.left);
		if(root.right!=null) postorderTraversal(root.right);
		result.add(root.val);
	}


}





