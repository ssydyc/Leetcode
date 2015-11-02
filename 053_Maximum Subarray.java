public class Solution {
    public int maxSubArray(int[] nums) {
        int res=0;
        int cur=0;
        int max=nums[0];
        for(int temp: nums){
            max=Math.max(temp,max);
            if(temp<0){
                res=Math.max(res,cur);
                cur+=temp;
                if(cur<0) cur=0;
            }
            else{
                cur+=temp;
            }
        }
        res=Math.max(res, cur);
        if(res==0) return max;
        return res;
    }
}
