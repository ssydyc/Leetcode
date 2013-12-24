/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
   	private ArrayList<Integer> result=new ArrayList<Integer>(); 
 	
 	
    public ArrayList<Integer> preorderTraversal(TreeNode root){
    	if(root==null) return result;
		Do_recurse(root);
		return result;
    }

	public void Do_recurse(TreeNode root){
		result.add(root.val);
		if(root.left!=null) preorderTraversal(root.left);
		if(root.right!=null) preorderTraversal(root.right);
	}


}



