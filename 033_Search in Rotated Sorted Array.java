public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int l=0, r=nums.length-1;
        // now we won't consider boundary case
        while(l<=r){
            int c=(l+r)/2;
            if(nums[l]==target) return l;
            if(nums[r]==target) return r;
            if(nums[c]==target) return c;
            
            if(nums[l]<nums[r]){
                if(nums[c]>target) r=c-1;
                else l=c+1;
            }
            else{ // the case nums[l]>nums[r]
                if(nums[c]>nums[l]){
                    if(target>nums[c]||target<nums[r]){
                        l=c+1;
                    }
                    else r=c-1;
                }
                else{ // nums[c]<nums[r]
                    if(target<nums[c]||target>nums[l]){
                        r=c-1;
                    }
                    else l=c+1;
                }
            }
        }
        return -1;
    }
}
