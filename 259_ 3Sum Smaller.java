public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int result=0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length;i++){
            int start=i+1, end=nums.length-1;
            while(start<end){
                if(nums[start]+nums[end]+nums[i]>=target) end--;
                else result+=end-(start++);
            }
        }
        return result;
    }
}
