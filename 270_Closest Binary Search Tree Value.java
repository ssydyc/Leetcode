/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class result{
    static double difference=Double.MAX_VALUE;
    static int num=0;
}
 
public class Solution {
    private void traverse(TreeNode root, double target){
        double temp=(double) root.val;
        if(Math.abs(temp-target)<result.difference){
            result.difference=Math.abs(temp-target);
            result.num=root.val;
        }
        if(root.left!=null) traverse(root.left,target);
        if(root.right!=null) traverse(root.right,target);
        return;
        
    }
    
    public int closestValue(TreeNode root, double target) {
        result.difference=Double.MAX_VALUE;;
        result.num=0;
        traverse(root, target);
        return result.num;
    }
}
