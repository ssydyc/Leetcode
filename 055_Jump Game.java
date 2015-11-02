public class Solution {
    public boolean canJump(int[] nums) {
        int reach=0;
        int n=nums.length;
        for(int i=0; i<n; i++){
            int temp=nums[i]+i;
            if(reach>=i && reach<temp) reach=temp;
        }
        if(reach>=n-1) return true;
        else return false;
    }
}
