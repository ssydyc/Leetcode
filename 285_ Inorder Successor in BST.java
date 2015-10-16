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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result=null;
        if(p.right!=null){
            result=p.right;
            while(result.left!=null) result=result.left;
            return result;
        }
        Stack<TreeNode> path= new Stack<TreeNode>();
        while(root!=p){
            path.push(root);
            if(root.val>p.val) root=root.left;
            else root=root.right;
        }
        path.push(p);
        TreeNode temp=path.pop();
        while(!path.isEmpty() && temp!=path.peek().left) temp=path.pop();
        if(path.isEmpty()) return null;
        else return path.pop();
    }
}
