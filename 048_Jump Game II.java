public class Solution {
    public int jump(int[] nums) {
        int res=-1;
        int reach=0;
        int cur=0;
        int len=nums.length;
        while(reach<len-1){
            res++;
            int temp=reach;
            for(int i=cur;i<=temp; i++){
                reach=Math.max(reach,i+nums[i]);
            }
            cur=temp+1;
        }
        return res+1;
    }
}
