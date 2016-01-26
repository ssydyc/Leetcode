/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class helper{
    TreeNode tn;
    int cur;
    public helper(TreeNode tn, int cur) {
        this.tn = tn;
        this.cur = cur;
    }
}
 
public class Solution {
    void inOrder(TreeNode root, int cur, int[] minMax){
        if(cur < minMax[0]) minMax[0] = cur;
        else if (cur > minMax[1]) minMax[1] = cur;
        if(root.left != null) inOrder(root.left, cur - 1, minMax);
        if(root.right != null) inOrder(root.right, cur + 1, minMax);
        return;
    }
    
    void addValue(TreeNode root, int cur, List<List<Integer>> res) {
        // row by row with BFS
        Queue<helper> q = new LinkedList<helper>();
        q.add(new helper(root, cur));
        while(!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                helper temp = q.poll();
                res.get(temp.cur).add(temp.tn.val);
                if(temp.tn.left != null) q.add(new helper(temp.tn.left, temp.cur - 1));
                if(temp.tn.right != null) q.add(new helper(temp.tn.right, temp.cur + 1));
            }
        }
        return;
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        int[] minMax = {0, 0};
        inOrder(root, 0, minMax);
        for(int i = minMax[0]; i <= minMax[1]; i++) {
            res.add(new ArrayList<Integer>());
        }
        addValue(root, 0 - minMax[0], res);
        return res;
    }
}
