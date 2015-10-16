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
    
    private void inOrderTraverse(TreeNode root, ArrayList<Integer> traverse){
        if(root.left!=null) inOrderTraverse(root.left,traverse);
        traverse.add(root.val);
        if(root.right!=null) inOrderTraverse(root.right,traverse);
        return;
    }
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        ArrayList<Integer> traverse=new ArrayList<Integer>();
        inOrderTraverse(root, traverse);
        int start=0, end=traverse.size();
        while(end-start>k){
            if(Math.abs(target-(double)traverse.get(start))>Math.abs(target-(double)traverse.get(end-1))) start++;
            else end--;
        }
        return traverse.subList(start,end);
    }
}
