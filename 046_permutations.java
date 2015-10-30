public class Solution {
    private void add(int[] nums, List<List<Integer>> res){
        List<Integer> temp= new ArrayList<Integer>();
        for(int temp1: nums) temp.add(temp1);
        res.add(temp);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
    private void helper(int[] nums, int index, List<List<Integer>> res){
        int len=nums.length;
        if(index<nums.length)
            helper(nums, index+1, res);
        else return;
        
        for(int j=index+1;j<len;j++){
            swap(nums,index,j);
            add(nums,res);
            helper(nums,index+1,res);
            swap(nums,index,j);
        }
        return;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        add(nums,res);
        helper(nums, 0, res);
        return res;
    }
}
