/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // get next possible String
    private String getString(int i, String s){
        int j=i;
        while(s.charAt(++j)!='|');
        return s.substring(i,j);
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder res=new StringBuilder();
        Stack<TreeNode> sk=new Stack<TreeNode>();
        while(root!=null){
            sk.push(root);
            res.append(Integer.toString(root.val));
            res.append('|');
            root=root.left;
        }
        res.append("#|"); // end of left tree
        while(!sk.empty()){
            TreeNode cur=sk.pop();
            if(cur.right!=null){
                cur=cur.right;
                while(cur!=null){
                    res.append(Integer.toString(cur.val));
                    res.append('|');
                    sk.push(cur);
                    cur=cur.left;
                }
                res.append("#|");
            }
            else{
                res.append(")|");
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        int index=0;
        Stack<TreeNode> sk=new Stack<TreeNode>();
        String s1=getString(0,data);
        index+=s1.length()+1;
        TreeNode root=new TreeNode(Integer.parseInt(s1));
        sk.push(root);
        boolean left=true;
        while(index<data.length()){
            s1=getString(index,data);
            index+=s1.length()+1;
            if(s1.equals("#")){
                left=false;
            }
            else if(s1.equals(")")){
                sk.pop();
                left=false;
            }
            else if(left){
                TreeNode temp=new TreeNode(Integer.parseInt(s1));
                sk.peek().left=temp;
                sk.push(temp);
            }
            else{
                TreeNode temp=new TreeNode(Integer.parseInt(s1));
                sk.pop().right=temp;
                sk.push(temp);
                left=true;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
