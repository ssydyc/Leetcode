public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low=Integer.MIN_VALUE, i=-1;
        for(int temp: preorder){
            if(temp<low) return false;
            while(i>=0&& preorder[i]<temp){
                low=preorder[i--];
            }
            preorder[++i]=temp;
        }
        return true;
    }
}
