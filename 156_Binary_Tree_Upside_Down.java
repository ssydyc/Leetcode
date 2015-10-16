/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
public class Solution {
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        Stack<TreeNode> leftNodes=new Stack<TreeNode>();
        while(root!=null){
            leftNodes.push(root);
            root=root.left;
        }
        TreeNode result=null;
        TreeNode current=null;
        while(!leftNodes.empty()){
            TreeNode temp=leftNodes.pop();
            if(result==null) {
                result=new TreeNode(temp.val);
                current=result;
            }
            else{
                if(temp.right!=null) current.left=new TreeNode(temp.right.val);
                current.right=new TreeNode(temp.val);
                current=current.right;
            }
        }
        return result;
    }
}
