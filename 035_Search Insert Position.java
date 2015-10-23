public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0, r=nums.length-1;
        if(nums.length==0|| nums[l]>=target) return l;
        while(l<=r){
            if(nums[r]<target) return r+1;
            if(nums[r]==target) return r;
            int c=(l+r)/2;
            if(nums[c]>target) r=c;
            else l=c;
            r--;
        }
        return l+1;
    }
}
