public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1) return;
        int ind=0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                int j=nums.length-1;
                while(nums[j]<=nums[i]) j--;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                ind=i+1;
                break;
            }
        }
        Arrays.sort(nums,ind,nums.length);
        return;
    }
}
