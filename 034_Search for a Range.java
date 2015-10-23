public class Solution {
    
    private int leftSearch(int[] nums, int target){
        int l=0, r=nums.length-1;
        while(r>=l){
            if(nums[l]==target) return l;
            int c=(r+l)/2;
            if(nums[c]>=target) r=c;
            else l=c;
            l++;
        }
        return -1;
    }
    
    private int rightSearch(int[] nums, int target){
        int l=0, r=nums.length-1;
        while(r>=l){
            if(nums[r]==target) return r;
            int c=(r+l)/2;
            if(nums[c]<=target) l=c;
            else r=c;
            r--;
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        res[0]=res[1]=-1;
        if(nums.length==0) return res;
        res[0]=leftSearch(nums,target);
        if(res[0]==-1) return res;
        res[1]=rightSearch(nums,target);
        return res;
    }
}
