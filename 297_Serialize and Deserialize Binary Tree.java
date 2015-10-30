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
        TreeNode nil=new TreeNode(0);
        nil.right=root;
        StringBuilder res=new StringBuilder();
        Stack<TreeNode> sk=new Stack<TreeNode>();
        sk.push(nil);
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
        TreeNode nil=new TreeNode(0);
        sk.push(nil);
        boolean left=false;
        while(index<data.length()){
            String s1=getString(index,data);
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
        return nil.right;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
