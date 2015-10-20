public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hs= new HashSet<List<Integer>>();
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        for(int i1=0; i1<nums.length-2; i1++){
            int i2=i1+1, i3=nums.length-1;
            while(i2!=i3){
                int sum=nums[i1]+nums[i2]+nums[i3];
                if(sum==0){
                    List<Integer> temp=new ArrayList<Integer>(Arrays.asList(nums[i1],nums[i2],nums[i3]));
                    if(!hs.contains(temp)) {
                        res.add(temp);
                        hs.add(temp);
                    }
                    i2++;
                }
                else if(sum<0) i2++;
                else i3--;
            }
        }
        return res;
    }
}
