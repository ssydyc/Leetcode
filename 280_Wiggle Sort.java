public class Solution {
    
    public void wiggleSort(int[] nums) {
        boolean increase=true;
        for(int i=1;i<nums.length;i++){
            if((increase&& nums[i-1]>nums[i])|| (!increase && nums[i-1]<nums[i])){
                int temp=nums[i-1];
                nums[i-1]=nums[i];
                nums[i]=temp;
            }
            increase=!increase;
        }
    }
}
