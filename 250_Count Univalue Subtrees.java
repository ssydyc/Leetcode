/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class helpNode{
    int val;
    boolean same;
    public helpNode(int val, boolean same){
        this.val=val;
        this.same=same;
    }
}
 
public class Solution {
    int result;
    private helpNode helper(TreeNode root){
        if(root==null) return null;
        helpNode temp=new helpNode(root.val,false);
        helpNode left=helper(root.left);
        helpNode right=helper(root.right);
        if(root.left!=null){
            if(!left.same|| left.val!=temp.val) return temp;
        }
        if(root.right!=null){
            if(!right.same|| right.val!=temp.val) return temp;
        }
        result++;
        temp.same=true;
        return temp;
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        result=0;
        helper(root);
        return result;
    }
}
